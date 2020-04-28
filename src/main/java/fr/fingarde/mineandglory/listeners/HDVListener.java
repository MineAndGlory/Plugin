package fr.fingarde.mineandglory.listeners;

import fr.fingarde.mineandglory.utils.ColorUtils;
import fr.fingarde.mineandglory.utils.HDVUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class HDVListener implements Listener
{
    @EventHandler
    public void onClick(InventoryClickEvent event) {
        if(!event.getView().getTitle().startsWith("Hotel des ventes")) return;

        event.setCancelled(true);
        ((Player) event.getWhoClicked()).updateInventory();

        if(event.getCurrentItem() == null) return;
        ItemStack clickedItem = event.getCurrentItem();

        Bukkit.broadcastMessage("1");
        int nextPage = 0;
        if(clickedItem.getItemMeta().getLocalizedName().equals("NEXT")) nextPage++;
        Bukkit.broadcastMessage("2");
        if(clickedItem.getItemMeta().getLocalizedName().equals("PREVIOUS")) nextPage--;
        Bukkit.broadcastMessage("3");
        if(nextPage == 0) {
            Bukkit.broadcastMessage("4");
            HDVUtils.openItem(clickedItem, (Player) event.getWhoClicked());
            Bukkit.broadcastMessage("5");
            return;
        }

        int page = Integer.parseInt(event.getView().getTitle().split("°")[1]);
        HDVUtils.openPage(page + nextPage, (Player) event.getWhoClicked());
    }
}
