package fr.fingarde.mineandglory.utils.managers;

import fr.fingarde.mineandglory.recipes.Recipes;
import fr.fingarde.mineandglory.recipes.StoneEquipement;
import org.bukkit.Material;
import org.bukkit.inventory.Recipe;

import java.util.Iterator;

import static org.bukkit.Bukkit.getServer;

public class CraftManager
{
    public static void removeCraft(Material m)
    {
        Iterator<Recipe> it = getServer().recipeIterator();
        Recipe recipe;
        while (it.hasNext())
        {
            recipe = it.next();
            if (recipe != null && recipe.getResult().getType() == m)
            {
                it.remove();
            }
        }
    }

    public static void registerCrafts() {
        registerCraft(new StoneEquipement());
    }

    private static void registerCraft(Recipes recipe) {
        recipe.register();
    }
}
