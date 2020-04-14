package fr.fingarde.mineandglory.listeners.items;

import fr.fingarde.mineandglory.objects.items.CustomItems;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class SpawnerListener implements Listener
{
    @EventHandler
    public void onBreak(BlockBreakEvent event) {
        if(event.getPlayer().getInventory().getItemInMainHand().getType() != Material.DIAMOND_PICKAXE) return;
        if(!event.getPlayer().getInventory().getItemInMainHand().getItemMeta().getLocalizedName().equalsIgnoreCase(CustomItems.BACKPACK.name())) return;

        event.setCancelled(true);
    }
}
