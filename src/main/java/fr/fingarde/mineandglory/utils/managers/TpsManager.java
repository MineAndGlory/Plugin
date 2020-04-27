package fr.fingarde.mineandglory.utils.managers;

import fr.fingarde.mineandglory.Main;
import fr.fingarde.mineandglory.utils.FloatUtils;
import org.bukkit.scheduler.BukkitRunnable;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class TpsManager
{
    private static double tps;
    private static long passedTime;

    public static final int REFRESH_RATE = 50;

    public static void refreshTPS()
    {
        new BukkitRunnable()
        {
            @Override
            public void run()
            {
                double millis = (System.currentTimeMillis() - passedTime);
                double seconds = millis / 1000.0;

                tps = (REFRESH_RATE / seconds);

                tps = FloatUtils.scaleDown(tps);

                passedTime = System.currentTimeMillis();
            }
        }.runTaskTimer(Main.getPlugin(), 0, REFRESH_RATE);
    }

    public static double getTps()
    {
        return tps;
    }
}
