package fr.fingarde.mineandglory.listeners;

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
        Bukkit.broadcastMessage("ouioiuo");
        Villager villager = event.getEntity();
        ItemStack coin = CustomItems.getFromValue(CustomItems.VILLAGER_COIN);

        MerchantRecipe recipe = new MerchantRecipe(coin, 90000);
        List<ItemStack> stacks = new ArrayList<>();
        stacks.add(coin);
        recipe.setIngredients(stacks);
        villager.setRecipe(0, recipe);
    }
}
