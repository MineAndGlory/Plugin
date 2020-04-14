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
        event.setMotd("§e§l§m--§9§8§l[§r §6§lThe Hypixel Network §8§l]§e§l§m--§8§l[ §eSub Line §8§l]§e§l§m-----§e§l§m ---§8§l[ §eNEWS:§8§l ]§e§m----§8§l[§r §e         §l HEADLINE           §8§l]§e§l§m-");
    }
}
