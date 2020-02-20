package fr.fingarde.mineandglory.recipes;

import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ShapelessCraft {

    private ItemStack result;
    private List<ItemStack> ingredients;

    public ShapelessCraft(ItemStack result) {
        this.result = result;
        this.ingredients = new LinkedList<>();
    }

    public void addIngredient(ItemStack itemStack) {
        ingredients.add(itemStack);
    }

    public ItemStack getResult() {
        return result;
    }

    /*public boolean equals(ItemStack[] itemStacks) {
        for(ItemStack ingredient : ingredients) {

            boolean present = false;
            for (ItemStack item : itemStacks) {
                if (item == null) continue;
                if (item.getItemMeta().getLocalizedName().equals(ingredient.getItemMeta().getLocalizedName()) && item.getType() == ingredient.getType()) {
                    present = true;
                }
            }


            if(!present) return false;
        }

        return true;
    }*/

    public boolean equals(ItemStack[] itemStacks) {
        List<ItemStack> stacks = new ArrayList<>();

        for(int i = 0; i < itemStacks.length; i++) {
            if(itemStacks[i] != null) {
                stacks.add(itemStacks[i]);
            }
        }

        for(ItemStack ingredient : ingredients) {

            ItemStack present = null;
            for (ItemStack item : itemStacks) {
                if (item == null) continue;
                if (item.getItemMeta().getLocalizedName().equals(ingredient.getItemMeta().getLocalizedName()) && item.getType() == ingredient.getType()) {
                    present = item;
                }
            }

            if(present == null) return false;
            else {
                stacks.remove(present);
            }
        }

        if(stacks.size() > 0) return false;
        return true;
    }
}
