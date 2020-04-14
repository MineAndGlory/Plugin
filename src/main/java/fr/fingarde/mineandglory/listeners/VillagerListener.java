package fr.fingarde.mineandglory.listeners;

import fr.fingarde.mineandglory.Main;
import fr.fingarde.mineandglory.objects.items.CustomItems;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.VillagerCareerChangeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.MerchantRecipe;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.List;

public class VillagerListener implements Listener
{
    @EventHandler
    public void onVillagerSpawn(VillagerCareerChangeEvent event) {
        Villager villager = event.getEntity();
        if(villager.getRecipes().size() != 0) return;
        Bukkit.broadcastMessage("ouioiuo");

        ItemStack coin = CustomItems.getFromValue(CustomItems.VILLAGER_COIN);

        new BukkitRunnable()
        {
            @Override
            public void run()
            {
                List<MerchantRecipe> recipes = villager.getRecipes();

                villager.setRecipes(recipes);

            }
        }.runTaskLater(Main.getPlugin(), 80);

    }
}
