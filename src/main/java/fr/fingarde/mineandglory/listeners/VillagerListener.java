package fr.fingarde.mineandglory.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.MerchantRecipe;

import java.util.List;

public class VillagerListener implements Listener
{
    @EventHandler
    public void onVillagerSpawn(PlayerInteractAtEntityEvent event) {
        if(event.getRightClicked().getType() != EntityType.VILLAGER) return;

        Villager villager = (Villager) event.getRightClicked();
        if(villager.getProfession() == Villager.Profession.NONE) return;

        List<MerchantRecipe> recipes = villager.getRecipes();
        Bukkit.broadcastMessage(recipes.size() + "");

        for(MerchantRecipe recipe : recipes)
        {
            ItemStack stack = recipe.getResult();
            stack.setAmount(60);
            MerchantRecipe recipe1 = new MerchantRecipe(stack, recipe.getMaxUses());
            recipe1.setIngredients(recipe1.getIngredients());
            villager.setRecipe(recipes.indexOf(recipe), recipe1);
        }
       // recipes.forEach(merchantRecipe -> );
       // villager.setRecipes(recipes);
    }
}
