package fr.fingarde.mineandglory;

import fr.fingarde.mineandglory.commands.CGive;
import fr.fingarde.mineandglory.listeners.*;
import fr.fingarde.mineandglory.listeners.jobs.MinerListener;
import fr.fingarde.mineandglory.objects.Rank;
import fr.fingarde.mineandglory.objects.User;
import fr.fingarde.mineandglory.recipes.Crafts;
import fr.fingarde.mineandglory.utils.Database;
import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

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

        Database.connectDB();
        Database.createTables();

        Rank.loadRanks();

        registerEvents();
        registerCommands();

        Crafts.registerCrafts();

        RestorePlayers();
    }

    @Override
    public void onDisable()
    {
        super.onDisable();
        Database.getSource().close();
    }

    public void registerEvents()
    {
        getServer().getPluginManager().registerEvents(new ChatListener(), this);

        getServer().getPluginManager().registerEvents(new PlayerBreakBlockByHandListener(), this);
        getServer().getPluginManager().registerEvents(new ForgeListener(), this);
        getServer().getPluginManager().registerEvents(new Crafts(), this);
        getServer().getPluginManager().registerEvents(new ConnectionListener(), this);
        getServer().getPluginManager().registerEvents(new BlockPathListener(), this);

        getServer().getPluginManager().registerEvents(new MinerListener(), this);
        getServer().getPluginManager().registerEvents(new BackpackListener(), this);
        getServer().getPluginManager().registerEvents(new EnderChestListener(), this);

        getServer().getPluginManager().registerEvents(new DoubleDoorListener(), this);
    }

    public void registerCommands()
    {
        getCommand("cgive").setExecutor(new CGive());
    }


    private void RestorePlayers()
    {
        new BukkitRunnable()
        {
            @Override
            public void run()
            {
                for (Player player : Bukkit.getOnlinePlayers())
                {
                    User user = new User(player.getUniqueId());

                    user.loadName();
                    user.loadPermissions();

                    User.users.add(user);

                    player.sendMessage("§cServer was reloaded!");
                }
            }
        }.runTaskAsynchronously(this);
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
