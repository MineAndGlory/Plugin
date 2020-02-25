package fr.fingarde.mineandglory.listeners.jobs;

import fr.fingarde.mineandglory.objects.User;
import fr.fingarde.mineandglory.objects.jobs.Miner;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class MinerListener implements Listener {
    @EventHandler
    public void onBreak(BlockBreakEvent event) {
        if(event.isCancelled()) return;
        Miner miner = Miner.getMiner("BREAK_" + event.getBlock().getType());

        if(miner == null) return;

        User user = User.getByUUID(event.getPlayer().getUniqueId());

        if(user.getJobs().getMinerLvl() < miner.getMinLvl()) {
            event.getPlayer().sendMessage("Vous ne pouvez pas miner ce bloc");
            return;
        }

        Bukkit.broadcastMessage("§a+" + miner.getXp() + "xp");
    }
}
