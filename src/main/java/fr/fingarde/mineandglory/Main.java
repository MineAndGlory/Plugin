package fr.fingarde.mineandglory;

import fr.fingarde.mineandglory.commands.CGive;
import fr.fingarde.mineandglory.listeners.ForgeListener;
import fr.fingarde.mineandglory.listeners.PlayerBreakBlockByHandListener;
import fr.fingarde.mineandglory.recipes.Crafts;
import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    private static Main plugin;
    private static ConsoleCommandSender console;

    @Override
    public void onEnable() {
        super.onEnable();
        plugin = this;
        console = Bukkit.getConsoleSender();

        //Database.connectDB();
        //Database.createTables();

        //Rank.loadRanks();


        registerEvents();
        registerCommands();

        Crafts.registerCrafts();
        //getCommand("cgive").setExecutor(new CGive());

        /*new BukkitRunnable() {
            @Override
            public void run() {
                for (Player player : Bukkit.getOnlinePlayers()) {
                    User user = new User(player.getUniqueId());

                    user.loadName();
                    user.loadPermissions();

                    User.users.add(user);

                    player.sendMessage("§cServer was reloaded!");
                }
            }
        }.runTaskAsynchronously(this);*/
    }

    @Override
    public void onDisable() {
        super.onDisable();
       // Database.getSource().close();
    }

    public void registerEvents() {
        getServer().getPluginManager().registerEvents(new PlayerBreakBlockByHandListener(), this);
        getServer().getPluginManager().registerEvents(new ForgeListener(), this);
        getServer().getPluginManager().registerEvents(new Crafts(), this);
        //getServer().getPluginManager().registerEvents(new DeathListener(), this);
    }

    public void registerCommands() {
        getCommand("cgive").setExecutor(new CGive());
    }
    // Getters

    public static Main getPlugin() {
        return plugin;
    }

    public static ConsoleCommandSender getConsole() {
        return console;
    }
}
