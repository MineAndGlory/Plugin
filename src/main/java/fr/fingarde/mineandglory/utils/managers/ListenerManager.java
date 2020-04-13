package fr.fingarde.mineandglory.utils.managers;

import fr.fingarde.mineandglory.Main;
import fr.fingarde.mineandglory.listeners.ChatListener;
import fr.fingarde.mineandglory.listeners.ConnectionListener;
import fr.fingarde.mineandglory.listeners.blocks.BlockPathListener;
import fr.fingarde.mineandglory.listeners.blocks.DoubleDoorListener;
import fr.fingarde.mineandglory.listeners.blocks.ForgeListener;
import fr.fingarde.mineandglory.listeners.blocks.PlayerBreakBlockByHandListener;
import fr.fingarde.mineandglory.listeners.items.BackpackListener;
import fr.fingarde.mineandglory.listeners.items.EnderChestListener;
import fr.fingarde.mineandglory.listeners.jobs.MinerListener;
import fr.fingarde.mineandglory.recipes.Crafts;
import org.bukkit.event.Listener;

public class ListenerManager
{
    public static void registerListeners()
    {
        register(new ChatListener());

        register(new PlayerBreakBlockByHandListener());
        register(new ForgeListener());
        register(new Crafts());
        register(new ConnectionListener());
        register(new BlockPathListener());

        register(new MinerListener());
        register(new BackpackListener());
        register(new EnderChestListener());

        register(new DoubleDoorListener());
    }

    private static void register(Listener listener)
    {
        Main.getPlugin().getServer().getPluginManager().registerEvents(listener, Main.getPlugin());
    }
}