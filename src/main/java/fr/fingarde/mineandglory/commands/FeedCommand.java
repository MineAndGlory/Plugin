package fr.fingarde.mineandglory.commands;

import fr.fingarde.mineandglory.utils.ErrorMessage;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FeedCommand implements CommandExecutor
{
    private static String permission = "command.feed";
    private static String permissionOther = "command.feed.other";

    private static String usage = "/feed [player]";

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] arguments)
    {
        if(!sender.hasPermission(permission)) {
            sender.sendMessage(ErrorMessage.noPermissionMessage(permission));
            return false;
        }

        if(arguments.length > 1) {
            sender.sendMessage(usage);
            return false;
        }

        Player player = null;
        if(arguments.length == 1) {
            if(!sender.hasPermission(permissionOther)) {
                sender.sendMessage(ErrorMessage.noPermissionMessage(permissionOther));
                return false;
            }

            for(Player onlinePlayer : Bukkit.getOnlinePlayers()) {
                if(onlinePlayer.getName().equalsIgnoreCase(arguments[0])) {
                    player = onlinePlayer;
                    break;
                }
            }
        }

        execute(sender, player);
        return false;
    }

    static void execute(CommandSender sender, Player player)
    {
        if(player == null) {
            if(!(sender instanceof Player)) {
                sender.sendMessage(ErrorMessage.onlyOnPlayer());
                return;
            }

            player = (Player) sender;
        }

        player.setFoodLevel(20);
        player.setSaturation(20);

        if(player != sender) sender.sendMessage("§aVous avez rassasié §b" + player.getName());
        player.sendMessage("§aVous avez été rassasié");
    }
}
