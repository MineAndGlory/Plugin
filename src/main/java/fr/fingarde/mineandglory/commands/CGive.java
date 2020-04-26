package fr.fingarde.mineandglory.commands;

import fr.fingarde.mineandglory.objects.items.CustomItems;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static fr.fingarde.mineandglory.objects.items.CustomItems.*;

public class CGive implements CommandExecutor
{
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings)
    {
        if (!(commandSender instanceof Player)) return true;

        ((Player) commandSender).getInventory().addItem(getFromValue(valueOf(strings[0].toUpperCase())));
        return false;
    }
}
