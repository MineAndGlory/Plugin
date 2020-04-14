package fr.fingarde.mineandglory.listeners;

import fr.fingarde.mineandglory.objects.items.CustomItems;
import org.bukkit.Material;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.VillagerCareerChangeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.MerchantRecipe;

import java.util.List;

public class VillagerListener implements Listener
{
    @EventHandler
    public void onVillagerSpawn(VillagerCareerChangeEvent event) {
        Villager villager = event.getEntity();
        ItemStack coin = CustomItems.getFromValue(CustomItems.VILLAGER_COIN);

        List<MerchantRecipe> recipes = villager.getRecipes();
        recipes.forEach(merchantRecipe -> {
            if(merchantRecipe.getResult().getType() == Material.EMERALD)
                merchantRecipe.getResult().setType(coin.getType());
                merchantRecipe.getResult().setItemMeta(coin.getItemMeta());
        });

        villager.setRecipes(recipes);
    }
}
