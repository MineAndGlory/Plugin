package fr.fingarde.mineandglory.listeners;

import fr.fingarde.mineandglory.utils.managers.TimeManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

public class ServerListListener implements Listener
{
    @EventHandler
    public void onPing(ServerListPingEvent event) {
        event.setMotd("§6§m               §r§7[ §r§eMineAndGlory  §7]§6§m        §r§7[  §b" + TimeManager.getHeure().replace(":", "h")  + "  §7]§6§m        \n" +
                "§r       §c§l≫ §r§cEn développement");
    }
}
