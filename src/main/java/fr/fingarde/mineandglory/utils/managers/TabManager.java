package fr.fingarde.mineandglory.utils.managers;

import fr.fingarde.mineandglory.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class TabManager
{
    public static void sheduleTablist()
    {
        new BukkitRunnable()
        {
            @Override
            public void run()
            {
                for (Player player : Bukkit.getOnlinePlayers())
                {
                    player.setPlayerListHeader(
                            "§r \n" +
                            "§r§eMine And Glory\n" +
                            "§r      §m                   §r      \n");

                    player.setPlayerListFooter(
                            "§r      §m                   §r      \n" +
                            "§rOnline: §b" + Bukkit.getOnlinePlayers().size() + "§r/§b" + Bukkit.getMaxPlayers() + "\n" +
                            "§rTPS: §a" + TpsManager.getTps() + "\n" +
                            "§r      §m                   §r      \n" +
                            "§r§e" + TimeManager.getHeure() + "\n" +
                            "§r ");
                }
            }
        }.runTaskTimer(Main.getPlugin(), 0, 10);
    }
}
