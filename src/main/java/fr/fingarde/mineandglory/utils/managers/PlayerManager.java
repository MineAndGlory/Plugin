package fr.fingarde.mineandglory.utils.managers;

import fr.fingarde.mineandglory.Main;
import fr.fingarde.mineandglory.objects.User;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class PlayerManager
{
    public static void restorePlayers()
    {
        new BukkitRunnable()
        {
            @Override
            public void run()
            {
                for (Player player : Bukkit.getOnlinePlayers())
                {
                    User user = new User(player.getUniqueId());

                    user.loadName();
                    user.loadPermissions();

                    User.users.add(user);

                    player.sendMessage("§cServer was reloaded!");
                }
            }
        }.runTaskAsynchronously(Main.getPlugin());
    }
}
