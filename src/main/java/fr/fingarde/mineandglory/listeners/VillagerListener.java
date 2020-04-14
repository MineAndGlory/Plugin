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
    public void onVillagerSpawn(VillagerCareerChangeEvent event) {
        new BukkitRunnable()
        {
            @Override
            public void run()
            {
                //if(event.getEntity().getType() != EntityType.VILLAGER) return;

                Villager villager = (Villager) event.getEntity();
                if(villager.getProfession() == Villager.Profession.NONE) return;

                List<MerchantRecipe> recipes = villager.getRecipes();
                Bukkit.broadcastMessage(recipes.size() + "");
                ItemStack coin = CustomItems.getFromValue(CustomItems.VILLAGER_COIN);

                for(MerchantRecipe recipe : recipes)
                {
                    ItemStack stack = recipe.getResult();
                    stack.setAmount(10);
                    if(stack.getType() == Material.EMERALD) {

                        stack.setType(coin.getType());
                        stack.setItemMeta(coin.getItemMeta());

                    }

                    List<ItemStack> ingredients = recipe.getIngredients();
                    MerchantRecipe recipe1 = new MerchantRecipe(stack, recipe.getMaxUses());

                    for(ItemStack itemStack : ingredients) {
                        if(itemStack.getType() != Material.EMERALD) continue;

                        itemStack.setType(coin.getType());
                        itemStack.setItemMeta(coin.getItemMeta());
                    }

                    recipe1.setIngredients(ingredients);
                    villager.setRecipe(recipes.indexOf(recipe), recipe1);
                }
            }
        }.runTaskLater(Main.getPlugin(), 1);

       // recipes.forEach(merchantRecipe -> );
       // villager.setRecipes(recipes);
    }
}
