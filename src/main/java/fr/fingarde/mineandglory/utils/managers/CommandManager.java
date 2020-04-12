package fr.fingarde.mineandglory.utils.managers;

import fr.fingarde.mineandglory.Main;
import fr.fingarde.mineandglory.commands.CGive;
import org.bukkit.command.CommandExecutor;

public class CommandManager
{
    public static void  registerCommands()
    {
        registerCommand("cgive", new CGive());
    }

    public static void registerCommand(String command, CommandExecutor commandExecutor) {
        Main.getPlugin().getCommand(command).setExecutor(commandExecutor);
    }
}
