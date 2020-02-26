package fr.fingarde.mineandglory.listeners.jobs;

import fr.fingarde.mineandglory.objects.User;
import fr.fingarde.mineandglory.objects.jobs.Miner;
import fr.fingarde.mineandglory.utils.Title;
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
            event.getPlayer().sendMessage("§cIl vous faut etre niveau " + miner.getMinLvl() + " mineur pour casser ce bloc");
            event.setCancelled(true);

            return;
        }

        Title.sendActionbar(event.getPlayer(), "§a+" + miner.getXp() + "xp");

        int oldExp = user.getJobs().getMinerExp();
        int newExp = oldExp + miner.getXp();

        user.getJobs().setMinerExp(newExp);
   
        Bukkit.broadcastMessage(newExp + "/" + (100 + 100 * ((user.getJobs().getMinerLvl() - 1) * 2.5)));
        if(newExp >= 100 + 100 * ((user.getJobs().getMinerLvl() - 1) * 2.5)) {
            user.getJobs().setMinerExp(0);
            user.getJobs().setMinerLvl(user.getJobs().getMinerLvl() + 1);
            Bukkit.broadcastMessage("You leveled up to lvl " + user.getJobs().getMinerLvl());
        }
    }
}
