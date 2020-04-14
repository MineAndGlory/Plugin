package fr.fingarde.mineandglory.listeners;

import fr.fingarde.mineandglory.utils.managers.TimeManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

public class ServerListListener implements Listener
{
    @EventHandler
    public void onPing(ServerListPingEvent event) {
        event.setMotd("§6§m               §r§7[ §r§eMineAndGlory  §7]§6§m        §r§7[  " + TimeManager.getHeure()  + "  §7]§6§m        \n       §c§l≫ En maintenance");
    }
}
