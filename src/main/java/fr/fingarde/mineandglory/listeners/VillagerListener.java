package fr.fingarde.mineandglory.listeners;

import fr.fingarde.mineandglory.objects.items.CustomItems;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.entity.VillagerCareerChangeEvent;
import org.bukkit.inventory.ItemStack;

public class VillagerListener implements Listener
{
    @EventHandler
    public void onVillagerSpawn(VillagerCareerChangeEvent event) {
        Villager villager = event.getEntity();
        ItemStack coin = CustomItems.getFromValue(CustomItems.VILLAGER_COIN);

        villager.getRecipes().forEach(merchantRecipe -> {
            if(merchantRecipe.getResult().getType() == Material.EMERALD)
                merchantRecipe.getResult().setType(coin.getType());
                merchantRecipe.getResult().setItemMeta(coin.getItemMeta());
        });
    }
}
