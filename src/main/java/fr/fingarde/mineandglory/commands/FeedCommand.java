package fr.fingarde.mineandglory.commands;

import fr.fingarde.mineandglory.utils.ErrorMessage;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FeedCommand implements CommandExecutor
{
    private static String permission = "command.enderchest";
    private static String permissionOther = "command.enderchest.other";

    private static String usage = "/feed [player]";

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] arguments)
    {
        if(arguments.length > 1) {
            sender.sendMessage(usage);
            return false;
        }

        Player player = null;
        if(arguments.length == 1) {
            for(Player onlinePlayer : Bukkit.getOnlinePlayers()) {
                if(onlinePlayer.getName().equalsIgnoreCase(arguments[0])) {
                    player = onlinePlayer;
                    break;
                }
            }
        }

        if(player == null) {
            if(sender instanceof Player) {
                sender.sendMessage(ErrorMessage.onlyOnPlayer());
                return false;
            }

            player = (Player) sender;
        }

        player.setFoodLevel(20);
        player.setSaturation(20);

        return false;
    }
}
