package fr.fingarde.mineandglory.listeners.items;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;


public class AmountListener implements Listener
{
    @EventHandler
    public void onPickup(EntityPickupItemEvent event) {
        if(!(event.getEntity() instanceof Player)) return;

        Player player = (Player) event.getEntity();
        Inventory inventory = player.getInventory();

        for(ItemStack item : inventory.getStorageContents()) {
            if(item.getType() == Material.AIR) {
                return;
            }
        }
        event.setCancelled(true);
    }
}
