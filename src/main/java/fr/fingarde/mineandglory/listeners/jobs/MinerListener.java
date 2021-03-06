package fr.fingarde.mineandglory.listeners.jobs;

import fr.fingarde.mineandglory.objects.Job;
import fr.fingarde.mineandglory.objects.User;
import fr.fingarde.mineandglory.objects.jobs.Miner;
import fr.fingarde.mineandglory.utils.TitleUtils;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class MinerListener implements Listener
{
    @EventHandler
    public void onBreak(BlockBreakEvent event)
    {
        if (event.isCancelled()) return;
        Miner miner = Miner.getMiner("BREAK_" + event.getBlock().getType());

        if (miner == null) return;

        User user = User.getByUUID(event.getPlayer().getUniqueId());

        if (user.getJobs().getMinerLvl() < miner.getMinLvl())
        {
            event.getPlayer().sendMessage("§cIl vous faut etre niveau " + miner.getMinLvl() + " mineur pour casser ce bloc");
            event.setCancelled(true);

            return;
        }

        TitleUtils.sendActionbar(event.getPlayer(), "§a+" + miner.getXp() + "xp");

        int currentLvl = user.getJobs().getMinerLvl();
        int oldExp = user.getJobs().getMinerExp();
        int newExp = oldExp + miner.getXp();


        int xpTotalForNextLvl = Job.getTotalXpForNextLvl(currentLvl + 1);

        Bukkit.broadcastMessage(newExp + "/" + xpTotalForNextLvl);
        if (newExp >= xpTotalForNextLvl)
        {
            user.getJobs().setMinerLvl(currentLvl + 1);
            Bukkit.broadcastMessage("§eYou leveled up to lvl " + user.getJobs().getMinerLvl());

            newExp = xpTotalForNextLvl / newExp;
        }

        user.getJobs().setMinerExp(newExp);
    }
}
