package fr.fingarde.mineandglory.utils.managers;

import fr.fingarde.mineandglory.Main;
import fr.fingarde.mineandglory.listeners.ChatListener;
import fr.fingarde.mineandglory.listeners.ConnectionListener;
import fr.fingarde.mineandglory.listeners.ServerListListener;
import fr.fingarde.mineandglory.listeners.VillagerListener;
import fr.fingarde.mineandglory.listeners.blocks.BlockPathListener;
import fr.fingarde.mineandglory.listeners.blocks.DoubleDoorListener;
import fr.fingarde.mineandglory.listeners.blocks.ForgeListener;
import fr.fingarde.mineandglory.listeners.blocks.PlayerBreakBlockByHandListener;
import fr.fingarde.mineandglory.listeners.items.BackpackListener;
import fr.fingarde.mineandglory.listeners.items.EnderChestListener;
import fr.fingarde.mineandglory.listeners.items.SpawnerListener;
import fr.fingarde.mineandglory.listeners.jobs.MinerListener;
import org.bukkit.event.Listener;

public class ListenerManager
{
    public static void registerListeners()
    {
        register(new ServerListListener());
        register(new ChatListener());

        register(new PlayerBreakBlockByHandListener());
        register(new ForgeListener());
        register(new ConnectionListener.CraftListener());
        register(new ConnectionListener());
        register(new BlockPathListener());

        register(new MinerListener());
        register(new BackpackListener());
        register(new EnderChestListener());

        register(new DoubleDoorListener());
        register(new VillagerListener());
        register(new SpawnerListener());
    }

    private static void register(Listener listener)
    {
        Main.getPlugin().getServer().getPluginManager().registerEvents(listener, Main.getPlugin());
    }
}
