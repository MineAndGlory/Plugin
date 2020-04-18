package fr.fingarde.mineandglory.listeners.items;

import fr.fingarde.mineandglory.objects.items.CustomItems;
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
        if(event.getItem().getItemStack().getItemMeta().getLocalizedName() == "") return;

        Player player = (Player) event.getEntity();
        Inventory inventory = player.getInventory();


        CustomItems customItems = CustomItems.valueOf((event.getItem().getItemStack().getItemMeta().getLocalizedName()));
        for(ItemStack item : inventory.getStorageContents()) {
            if(item == null ) {
                return;
            }
        }
        event.setCancelled(true);
    }
}
