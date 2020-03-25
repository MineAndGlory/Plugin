package fr.fingarde.mineandglory.listeners;

import fr.fingarde.mineandglory.items.CustomItems;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerBreakBlockByHandListener implements Listener
{
    @EventHandler
    public void onBreakStone(BlockBreakEvent event)
    {
        if (event.getBlock().getType() != Material.STONE) return;
        if (event.getPlayer().getInventory().getItemInMainHand().getType().name().endsWith("_PICKAXE")) return;

        event.setDropItems(false);
        Location location = event.getBlock().getLocation();

        location.getWorld().dropItemNaturally(location, CustomItems.getFromValue(CustomItems.ROCK));
    }

    @EventHandler
    public void onBreakWood(BlockBreakEvent event)
    {
        if (!event.getBlock().getType().name().endsWith("_LOG")) return;
        if (event.getPlayer().getInventory().getItemInMainHand().getType().name().endsWith("_AXE")) return;

        event.setDropItems(false);
        Location location = event.getBlock().getLocation();

        location.getWorld().dropItemNaturally(location, new ItemStack(Material.STICK));
    }
}
