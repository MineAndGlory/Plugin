package fr.fingarde.mineandglory.listeners;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

public class ServerListListener implements Listener
{
    @EventHandler
    public void onPing(ServerListPingEvent event) {
        event.iterator().remove();
    }
}
