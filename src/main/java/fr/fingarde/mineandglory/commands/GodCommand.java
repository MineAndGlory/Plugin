package fr.fingarde.mineandglory.commands;

import fr.fingarde.mineandglory.utils.ErrorMessage;
import org.bukkit.Bukkit;
import org.bukkit.attribute.Attribute;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GodCommand implements CommandExecutor
{
    private static String permission = "command.god";
    private static String permissionOther = "command.god.other";

    private static String usage = "/god [player] [on|off]";

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] arguments)
    {
        if(!sender.hasPermission(permission)) {
            sender.sendMessage(ErrorMessage.noPermissionMessage(permission));
            return false;
        }

        if(arguments.length > 2) {
            sender.sendMessage(usage);
            return false;
        }

        int state = -2;
        Player player = null;

        if(arguments.length >= 1) {
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

            if(arguments.length == 1) {
                if(player == null) {
                    state = switchVal(arguments[0]);
                }
            }
            else {
                state = switchVal(arguments[1]);
            }
        }

       if(state == -1) {
            sender.sendMessage(usage);
           return false;
       }

        execute(sender, player, state);
        return false;
    }

    static void execute(CommandSender sender, Player player, int state)
    {
        if(player == null) {
            if(!(sender instanceof Player)) {
                sender.sendMessage(ErrorMessage.onlyOnPlayer());
                return;
            }

            player = (Player) sender;
        }

        boolean bool = switch (state)
                {
                    case 1 -> true;
                    case 0 -> false;
                    default -> !player.isInvulnerable();
                };

        player.setInvulnerable(bool);

        if(player != sender) sender.sendMessage("§aVous avez rendu invulerable §b" + player.getName());
        player.sendMessage("§aVous êtes invulerable");
    }

    private int switchVal(String val) {
        return switch (val.toLowerCase()) {
            case "on", "true" -> 1;
            case "off", "false" -> 0;
            default -> -1;
        };
    }
}
