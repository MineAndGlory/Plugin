package fr.fingarde.mineandglory.utils.managers;

import fr.fingarde.mineandglory.Main;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.scheduler.BukkitRunnable;

public class TimeManager
{
    private static final int TIME_MULTIPLIER = 3;
    private static String heure;

    public static void updateGameTime()
    {
        new BukkitRunnable()
        {
            @Override
            public void run()
            {
                for (World world : Bukkit.getWorlds())
                {
                    world.setFullTime(world.getFullTime() + 1);
                }

                long gameTime = Bukkit.getWorld("world").getTime() + 6000;
                int hours = (int) Math.floor(gameTime / 1000);
                int minutes = (int) ((gameTime % 1000) / 1000.0 * 60);
                if (hours >= 24) hours -= 24;

                heure = String.format("%02d", hours) + ":" + String.format("%02d", minutes);
            }
        }.runTaskTimer(Main.getPlugin(), 0 , TIME_MULTIPLIER);
    }

    public static String getHeure()
    {
        return heure;
    }
}
