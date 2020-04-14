package fr.fingarde.mineandglory.listeners;

import fr.fingarde.mineandglory.Main;
import fr.fingarde.mineandglory.objects.items.CustomItems;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.VillagerCareerChangeEvent;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.MerchantRecipe;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.List;

public class VillagerListener implements Listener
{
    @EventHandler
    public void onVillagerSpawn(PlayerInteractAtEntityEvent event) {
        if(event.getRightClicked().getType() != EntityType.VILLAGER) return;

        Villager villager = (Villager) event.getRightClicked();
        if(villager.getProfession() == Villager.Profession.NONE) return;

        List<MerchantRecipe> recipes = villager.getRecipes();
        recipes.forEach(merchantRecipe -> merchantRecipe.getResult().setType(Material.STONE));


    }
}
