package fr.fingarde.mineandglory.listeners.items;

import fr.fingarde.mineandglory.objects.items.CustomItems;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class SpawnerListener implements Listener
{
    @EventHandler
    public void onBreak(BlockBreakEvent event)
    {
        if (event.getPlayer().getInventory().getItemInMainHand().getType() != Material.DIAMOND_PICKAXE) return;
        if (!event.getPlayer().getInventory().getItemInMainHand().getItemMeta().getLocalizedName().equals(CustomItems.SPAWNER_PICKAXE.name()))
            return;
        if (event.getBlock().getType() != Material.SPAWNER) return;

        event.setExpToDrop(0);

        ItemStack spawner = new ItemStack(Material.SPAWNER);
        ItemMeta meta = spawner.getItemMeta();

        String entityType = ((CreatureSpawner) event.getBlock().getState()).getSpawnedType().name();

        meta.setDisplayName(entityType.substring(0,1) + entityType.substring(1).toLowerCase() + " Spawner");
        meta.setLocalizedName(entityType);
        spawner.setItemMeta(meta);

        event.getBlock().getWorld().dropItem(event.getBlock().getLocation(), spawner);

    }

    @EventHandler
    public void onPlace(BlockPlaceEvent event)
    {
        if (event.getBlock().getType() != Material.SPAWNER) return;
        if (event.getItemInHand().getItemMeta().getLocalizedName() == "") return;

        CreatureSpawner spawner = (CreatureSpawner) event.getBlock().getState();

        spawner.setSpawnedType(EntityType.valueOf(event.getItemInHand().getItemMeta().getLocalizedName()));
        spawner.update();
    }
}
