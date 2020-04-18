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
        Bukkit.broadcastMessage("1");
        if(!(event.getEntity() instanceof Player)) return;
        if(event.getItem().getItemStack().getItemMeta().getLocalizedName() == "") return;
        Bukkit.broadcastMessage("2");
        Player player = (Player) event.getEntity();
        Inventory inventory = player.getInventory();

        ItemStack item = event.getItem().getItemStack();
        CustomItems customItem = CustomItems.valueOf((event.getItem().getItemStack().getItemMeta().getLocalizedName()));
        Bukkit.broadcastMessage("3");
        for(ItemStack itemInInventory : inventory.getStorageContents()) {
            if(itemInInventory == null ) {
                // Add correct amount
                Bukkit.broadcastMessage("4");
                if(item.getAmount() <= customItem.getMaxStack()) return;
                Bukkit.broadcastMessage("5");
                //inventory.addItem(item)
            }

            Bukkit.broadcastMessage("6");
            if(itemInInventory.getItemMeta().getLocalizedName() == "") continue;
            CustomItems customItemInInventory = CustomItems.valueOf(itemInInventory.getItemMeta().getLocalizedName());

            Bukkit.broadcastMessage("7");
            if(customItemInInventory != customItem) continue;
            Bukkit.broadcastMessage("8");
            if(customItemInInventory.getMaxStack() >= itemInInventory.getAmount()) continue;

            Bukkit.broadcastMessage("9");
            itemInInventory.setAmount(itemInInventory.getAmount() + 1);
        }

        Bukkit.broadcastMessage("10");
        event.setCancelled(true);
    }
}
