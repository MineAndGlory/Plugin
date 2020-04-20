package fr.fingarde.mineandglory.listeners.blocks;

import fr.fingarde.mineandglory.utils.managers.LootTableManager;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.Ageable;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockGrowEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class CropsListener implements Listener
{
    @EventHandler
    public void onGrow(BlockGrowEvent event)
    {
        Block block = event.getBlock();
        Ageable ageable = (Ageable) block.getBlockData();

        if (!isCrop(block.getType())) return;

        event.setCancelled(true);
        if (ageable.getAge() + 1 == ageable.getMaximumAge())
        {
            return;
        }

        ageable.setAge(ageable.getAge() + 2);

        block.setBlockData(ageable);
    }

    @EventHandler
    public void onClick(PlayerInteractEvent event)
    {
        LootTableManager.getDrops("potatoes", event.getItem()).forEach(itemStack -> event.getPlayer().getWorld().dropItem(event.getPlayer().getLocation(), itemStack));
    }

    private boolean isCrop(Material material)
    {


        switch (material)
        {
            case WHEAT:
            case POTATOES:
            case CARROTS:
            case BEETROOTS:
                return true;
        }

        return false;
    }
}
