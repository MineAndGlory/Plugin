package fr.fingarde.mineandglory.listeners.jobs;

import fr.fingarde.mineandglory.objects.jobs.Miner;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class MinerListener implements Listener {
    @EventHandler
    public void onBreak(BlockBreakEvent event) {
        if(event.isCancelled()) return;
        int xp = Miner.getXp("BREAK_" + event.getBlock().getType());

        if(xp == 0) return;
        Bukkit.broadcastMessage("§a+" + xp + "xp");
    }
}
