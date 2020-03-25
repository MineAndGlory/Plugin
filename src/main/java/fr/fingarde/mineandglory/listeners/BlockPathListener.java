package fr.fingarde.mineandglory.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class BlockPathListener implements Listener
{

    @EventHandler
    public void onMove(PlayerMoveEvent event)
    {
        if (event.getPlayer().getLocation().getBlock().getType() == Material.GRASS_PATH)
        {
            event.getPlayer().removePotionEffect(PotionEffectType.SPEED);
            event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 100, 1, true, false, false));
        }
    }

}
