package fr.fingarde.mineandglory.commands.hdv;

import fr.fingarde.mineandglory.utils.ErrorMessage;
import fr.fingarde.mineandglory.utils.FloatUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class HDVCommand implements CommandExecutor
{
    private static String permission = "command.hdv";
    private static String permissionSell = "command.hdv.sell";

    private static String usage = "/hdv [sell <price>]";

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] arguments)
    {
        if(!(sender instanceof Player)) {
            sender.sendMessage(ErrorMessage.onlyOnPlayer());
            return false;
        }

        if(!sender.hasPermission(permission)) {
            sender.sendMessage(ErrorMessage.noPermissionMessage(permission));
            return false;
        }

        if(arguments.length > 2) {
            sender.sendMessage(usage);
            return false;
        }

        Player player = player = (Player) sender;

        if(arguments.length > 0) {
            if(!sender.hasPermission(permissionSell)) {
                sender.sendMessage(ErrorMessage.noPermissionMessage(permissionSell));
                return false;
            }

            if(!arguments[0].equalsIgnoreCase("sell")) {
                sender.sendMessage(usage);
                return false;
            }

            executeSell(player, arguments[1]);
        }
        else
        {
        // open hdv
        }


        return false;
    }

    private void executeSell(Player player, String priceString)
    {
        ItemStack itemStack = player.getInventory().getItemInMainHand();

        if(itemStack == null)
        {
            player.sendMessage(ErrorMessage.emptyHand());
        }

        float price = -1;
        try {
            price = Float.parseFloat(priceString);
        }
        catch (NumberFormatException e) {
            player.sendMessage(ErrorMessage.invalidPrice());
             return;
        }

        price = FloatUtils.scaleDown(price);

        if(price < 0) {
            player.sendMessage(ErrorMessage.invalidPrice());
            return;
        }

        Bukkit.broadcastMessage(player.getName() + " a mit au enchères " + itemStack.getAmount() + "x " + itemStack.getType().toString().toLowerCase() + " pour " + price + "$");
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
