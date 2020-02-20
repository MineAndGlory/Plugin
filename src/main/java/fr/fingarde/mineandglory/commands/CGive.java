package fr.fingarde.mineandglory.commands;

import fr.fingarde.mineandglory.items.CustomItems;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.PluginCommand;
import org.bukkit.entity.Player;

public class CGive implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(! (commandSender instanceof Player)) return true;

        ((Player) commandSender).getInventory().addItem(CustomItems.getFromValue(CustomItems.valueOf(strings[0].toUpperCase())));
        return false;
    }
}
