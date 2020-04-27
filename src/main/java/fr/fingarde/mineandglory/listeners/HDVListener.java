package fr.fingarde.mineandglory.listeners;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class HDVListener implements Listener
{
    @EventHandler
    public void onClick(InventoryClickEvent event) {
        if(!event.getView().getTitle().equals("Hotel des ventes")) return;

        event.setCancelled(true);

        if(event.getCurrentItem() == null) return;
        Bukkit.broadcastMessage(event.getCurrentItem().getType().name());
    }
}
