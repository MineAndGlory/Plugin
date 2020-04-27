package fr.fingarde.mineandglory.utils.managers;

import fr.fingarde.mineandglory.Main;
import fr.fingarde.mineandglory.utils.FloatUtils;
import org.bukkit.scheduler.BukkitRunnable;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class TpsManager
{
    private static float tps;
    private static long passedTime;

    public static void refreshTPS()
    {
        new BukkitRunnable()
        {
            @Override
            public void run()
            {
                long millis = (System.currentTimeMillis() - passedTime);
                float seconds = millis / 1000f;

                tps = (100 / seconds);


                tps = FloatUtils.scaleDown(tps);

                passedTime = System.currentTimeMillis();
            }
        }.runTaskTimer(Main.getPlugin(), 0L, 100L);
    }

    public static double getTps()
    {
        return tps;
    }
}
