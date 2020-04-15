package fr.fingarde.mineandglory.utils.managers;

import fr.fingarde.mineandglory.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class TabManager
{
    private static int switchMode = 0; // Every 80tips switch mode to the next one

    private static String modes[] = {"§aSite: §rmineandglory.fr", "Join us §9/discord"};
    private static int current = 0;

    public static void sheduleTablist()
    {
        new BukkitRunnable()
        {
            @Override
            public void run()
            {
                if (switchMode == 8)
                {
                    current = (current + 1) % modes.length;
                    switchMode = 0;
                }

                Bukkit.getOnlinePlayers().forEach(player ->
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
                                    "§r" + modes[current] + "\n" +
                                    "§r      §m                   §r      \n" +
                                    "§r§e" + TimeManager.getHeure() + "\n" +
                                    "§r ");
                });

                switchMode++;
            }
        }.runTaskTimer(Main.getPlugin(), 0, 10);
    }
}
