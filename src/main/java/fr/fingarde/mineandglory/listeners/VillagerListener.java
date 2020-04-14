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

import java.util.List;

public class VillagerListener implements Listener
{
    @EventHandler
    public void onVillagerSpawn(VillagerCareerChangeEvent event)
    {
        new BukkitRunnable()
        {
            @Override
            public void run()
            {
                Villager villager = event.getEntity();
                if (villager.getProfession() == Villager.Profession.NONE) return;

                List<MerchantRecipe> recipes = villager.getRecipes();
                ItemStack coin = CustomItems.getFromValue(CustomItems.VILLAGER_COIN);

                for (MerchantRecipe oldRecipe : recipes)
                {
                    ItemStack result = oldRecipe.getResult();
                    if (result.getType() == Material.EMERALD)
                    {
                        result.setType(coin.getType());
                        result.setItemMeta(coin.getItemMeta());
                    }

                    List<ItemStack> ingredients = oldRecipe.getIngredients();
                    MerchantRecipe newRecipe = new MerchantRecipe(result, oldRecipe.getMaxUses());

                    for (ItemStack ingredient : ingredients)
                    {
                        if (ingredient.getType() != Material.EMERALD) continue;

                        ingredient.setType(coin.getType());
                        ingredient.setItemMeta(coin.getItemMeta());
                    }

                    newRecipe.setMaxUses(oldRecipe.getMaxUses());
                    newRecipe.setExperienceReward(oldRecipe.hasExperienceReward());
                    newRecipe.setPriceMultiplier(oldRecipe.getPriceMultiplier());
                    newRecipe.setUses(oldRecipe.getUses());
                    newRecipe.setVillagerExperience(oldRecipe.getVillagerExperience());

                    newRecipe.setIngredients(ingredients);
                    villager.setRecipe(recipes.indexOf(oldRecipe), newRecipe);
                }
            }
        }.runTaskLater(Main.getPlugin(), 1);

        // recipes.forEach(merchantRecipe -> );
        // villager.setRecipes(recipes);
    }
}
