package fr.fingarde.mineandglory.listeners;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

import java.util.Iterator;

public class ServerListListener implements Listener
{
    @EventHandler
    public void onPing(ServerListPingEvent event) {
        event.setMotd("§6§m               §r§7[ §r§eMineAndGlory  §7]§6§m        §r§7[  20h12  §7]§6§m        \n§c§l≫ En maintenance");
    }
}
