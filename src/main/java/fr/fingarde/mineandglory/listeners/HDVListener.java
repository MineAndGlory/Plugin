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
    public void onClickMenu(InventoryClickEvent event) {
        if(!event.getView().getTitle().startsWith("Hotel des ventes - page N°")) return;
        if(event.getCurrentItem() == null) return;

        event.setCancelled(true);
        ((Player) event.getWhoClicked()).updateInventory();

        ItemStack clickedItem = event.getCurrentItem();

        int nextPage = 0;
        if(clickedItem.getItemMeta().getLocalizedName().equals("NEXT")) nextPage++;
        if(clickedItem.getItemMeta().getLocalizedName().equals("PREVIOUS")) nextPage--;

        if(nextPage == 0) {
            HDVUtils.openItem(clickedItem, (Player) event.getWhoClicked());
            return;
        }

        int page = Integer.parseInt(event.getView().getTitle().split("°")[1]);
        HDVUtils.openPage(page + nextPage, (Player) event.getWhoClicked());
    }

    @EventHandler
    public void onClickBuy(InventoryClickEvent event) {
        if(!event.getView().getTitle().startsWith("Hotel des ventes - Achat")) return;
        if(event.getCurrentItem() == null) return;

        event.setCancelled(true);
        ((Player) event.getWhoClicked()).updateInventory();

        ItemStack clickedItem = event.getCurrentItem();
        if(clickedItem.getItemMeta().getLocalizedName().startsWith("CANCEL:")) {
            int page = Integer.parseInt(event.getView().getTitle().split(":")[1]);

            HDVUtils.openPage(page, (Player) event.getWhoClicked());
        }

        /*
        int nextPage = 0;
        if(clickedItem.getItemMeta().getLocalizedName().equals("NEXT")) nextPage++;
        if(clickedItem.getItemMeta().getLocalizedName().equals("PREVIOUS")) nextPage--;

        if(nextPage == 0) {
            HDVUtils.openItem(clickedItem, (Player) event.getWhoClicked());
            return;
        }

        int page = Integer.parseInt(event.getView().getTitle().split("°")[1]);
        HDVUtils.openPage(page + nextPage, (Player) event.getWhoClicked());*/
    }
}
