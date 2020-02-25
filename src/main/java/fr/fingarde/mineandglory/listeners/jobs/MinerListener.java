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
        Miner minerBlock = Miner.valueOf("BREAK_" + event.getBlock().getType());

        Bukkit.broadcastMessage("§a+" + minerBlock.getXp() + "xp");
    }
}
