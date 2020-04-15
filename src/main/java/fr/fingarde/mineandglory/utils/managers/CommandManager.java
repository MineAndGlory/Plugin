package fr.fingarde.mineandglory.utils.managers;

import fr.fingarde.mineandglory.Main;
import fr.fingarde.mineandglory.commands.CGive;
import fr.fingarde.mineandglory.commands.EnderChestCommand;
import fr.fingarde.mineandglory.commands.FeedCommand;
import org.bukkit.command.CommandExecutor;

public class CommandManager
{
    public static void  registerCommands()
    {
        registerCommand("enderchest", new EnderChestCommand());
        registerCommand("feed", new FeedCommand());
        registerCommand("cgive", new CGive());
    }

    public static void registerCommand(String command, CommandExecutor commandExecutor) {
        Main.getPlugin().getCommand(command).setExecutor(commandExecutor);
    }
}
