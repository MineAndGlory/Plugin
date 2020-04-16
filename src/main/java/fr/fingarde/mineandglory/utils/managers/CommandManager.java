package fr.fingarde.mineandglory.utils.managers;

import fr.fingarde.mineandglory.Main;
import fr.fingarde.mineandglory.commands.*;
import org.bukkit.command.CommandExecutor;

public class CommandManager
{
    public static void  registerCommands()
    {
        registerCommand("enderchest", new EnderChestCommand());
        registerCommand("feed", new FeedCommand());
        registerCommand("heal", new HealCommand());
        registerCommand("god", new GodCommand());
        registerCommand("cgive", new CGive());
    }

    public static void registerCommand(String command, CommandExecutor commandExecutor) {
        Main.getPlugin().getCommand(command).setExecutor(commandExecutor);
    }
}
