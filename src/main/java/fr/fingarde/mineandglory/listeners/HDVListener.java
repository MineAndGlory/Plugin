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

        if(event.getCurrentItem() == null) return;
        ItemStack clickedItem = event.getCurrentItem();

        Bukkit.broadcastMessage(event.getCurrentItem().getType().name());

        int page = Integer.parseInt(ColorUtils.unhideChars(event.getView().getTitle()).split(":")[1]);
        HDVUtils.openPage(page + 1, (Player) event.getWhoClicked());
    }
}
