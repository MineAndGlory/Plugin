package fr.fingarde.mineandglory.listeners.blocks;

import org.bukkit.block.Block;
import org.bukkit.block.data.Ageable;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockGrowEvent;

public class CropsListener implements Listener
{
    @EventHandler
    public void onGrow(BlockGrowEvent event)
    {
        Block block = event.getBlock();
        Ageable ageable = (Ageable) block.getBlockData();

        // need crops
        event.setCancelled(true);

        if (ageable.getAge() + 1 == ageable.getMaximumAge())
        {
            return;
        }

        ageable.setAge(ageable.getAge() + 2);

        block.setBlockData(ageable);
    }
}
