package fr.fingarde.mineandglory.listeners.items;

import fr.fingarde.mineandglory.objects.items.CustomItems;
import org.bukkit.Bukkit;
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
        Bukkit.broadcastMessage("EE");
        if(!(event.getEntity() instanceof Player)) return;
        if(event.getItem().getItemStack().getItemMeta().getLocalizedName() == "") return;

        Player player = (Player) event.getEntity();
        Inventory inventory = player.getInventory();

        CustomItems customItem = CustomItems.valueOf((event.getItem().getItemStack().getItemMeta().getLocalizedName()));
        for(ItemStack itemInInventory : inventory.getStorageContents()) {
            if(itemInInventory == null ) {
                return;
            }

            if(itemInInventory.getItemMeta().getLocalizedName() == "") continue;
            CustomItems customItemInInventory = CustomItems.valueOf(itemInInventory.getItemMeta().getLocalizedName());

            if(customItemInInventory != customItem) continue;
            if(customItemInInventory.getMaxStack() == itemInInventory.getAmount()) continue;

            itemInInventory.setAmount(itemInInventory.getAmount() + 1);
        }
        event.setCancelled(true);
    }
}
