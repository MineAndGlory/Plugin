package fr.fingarde.mineandglory;

import fr.fingarde.mineandglory.objects.Rank;
import fr.fingarde.mineandglory.utils.managers.*;
import fr.fingarde.mineandglory.utils.storage.Database;
import org.bukkit.Bukkit;
import org.bukkit.GameRule;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin
{
    private static Main plugin;
    private static ConsoleCommandSender console;

    @Override
    public void onEnable()
    {
        super.onEnable();

        plugin = this;
        console = Bukkit.getConsoleSender();

        Bukkit.getWorlds().forEach(world -> world.setGameRule(GameRule.DO_DAYLIGHT_CYCLE, false));

        Database.connectDB();
        Database.createTables();

        Rank.loadRanks();

        ListenerManager.registerListeners();
        CommandManager.registerCommands();

        TpsManager.refreshTPS();
        TimeManager.updateGameTime();
        TabManager.sheduleTablist();

        CraftManager.registerCrafts();

        PlayerManager.restorePlayers();
    }

    @Override
    public void onDisable()
    {
        super.onDisable();
        Database.getSource().close();
    }

    // Getters

    public static Main getPlugin()
    {
        return plugin;
    }

    public static ConsoleCommandSender getConsole()
    {
        return console;
    }
}
