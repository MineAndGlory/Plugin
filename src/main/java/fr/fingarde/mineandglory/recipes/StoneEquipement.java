package fr.fingarde.mineandglory.recipes;

import fr.fingarde.mineandglory.objects.items.CustomItems;
import fr.fingarde.mineandglory.utils.managers.CraftManager;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import static fr.fingarde.mineandglory.listeners.ConnectionListener.CraftListener.shapelessCrafts;

public class StoneEquipement implements Recipes
{
    @Override
    public void register()
    {
        ShapelessCraft stonePickaxe = new ShapelessCraft(new ItemStack(Material.STONE_PICKAXE));
        stonePickaxe.addIngredient(CustomItems.getFromValue(CustomItems.STONE_PICKAXE_HEAD));
        stonePickaxe.addIngredient(new ItemStack(Material.STICK));
        shapelessCrafts.add(stonePickaxe);

        ShapelessCraft stoneShovel = new ShapelessCraft(new ItemStack(Material.STONE_SHOVEL));
        stoneShovel.addIngredient(CustomItems.getFromValue(CustomItems.STONE_SHOVEL_HEAD));
        stoneShovel.addIngredient(new ItemStack(Material.STICK));
        shapelessCrafts.add(stoneShovel);

        ShapelessCraft stoneSword = new ShapelessCraft(new ItemStack(Material.STONE_SWORD));
        stoneSword.addIngredient(CustomItems.getFromValue(CustomItems.STONE_SWORD_HEAD));
        stoneSword.addIngredient(new ItemStack(Material.STICK));
        shapelessCrafts.add(stoneSword);

        ShapelessCraft stoneHammer = new ShapelessCraft(new ItemStack(Material.STONE_SWORD)); // TODO ADD HAMMER
        stoneHammer.addIngredient(CustomItems.getFromValue(CustomItems.STONE_HAMMER_HEAD));
        stoneHammer.addIngredient(new ItemStack(Material.STICK));
        shapelessCrafts.add(stoneHammer);

        ShapelessCraft stoneBlacksmithHammer = new ShapelessCraft(new ItemStack(Material.STONE_SWORD)); // TODO ADD BLACKSMITH HAMMER
        stoneBlacksmithHammer.addIngredient(CustomItems.getFromValue(CustomItems.STONE_BLACKSMITH_HAMMER_HEAD));
        stoneBlacksmithHammer.addIngredient(new ItemStack(Material.STICK));
        shapelessCrafts.add(stoneBlacksmithHammer);

        ShapelessCraft stoneExcavator = new ShapelessCraft(new ItemStack(Material.STONE_SWORD)); // TODO ADD EXCAVATOR
        stoneExcavator.addIngredient(CustomItems.getFromValue(CustomItems.STONE_EXCAVATOR_HEAD));
        stoneExcavator.addIngredient(new ItemStack(Material.STICK));
        shapelessCrafts.add(stoneExcavator);

        ShapelessCraft stoneHoe = new ShapelessCraft(new ItemStack(Material.STONE_HOE));
        stoneHoe.addIngredient(CustomItems.getFromValue(CustomItems.STONE_HOE_HEAD));
        stoneHoe.addIngredient(new ItemStack(Material.STICK));
        shapelessCrafts.add(stoneHoe);

        ShapelessCraft stoneDagger = new ShapelessCraft(new ItemStack(Material.STONE_SWORD)); // TODO ADD DAGGER
        stoneDagger.addIngredient(CustomItems.getFromValue(CustomItems.STONE_DAGGER_HEAD));
        stoneDagger.addIngredient(new ItemStack(Material.STICK));
        shapelessCrafts.add(stoneDagger);

        ShapelessCraft stoneAxe = new ShapelessCraft(new ItemStack(Material.STONE_AXE));
        stoneAxe.addIngredient(CustomItems.getFromValue(CustomItems.STONE_AXE_HEAD));
        stoneAxe.addIngredient(new ItemStack(Material.STICK));
        shapelessCrafts.add(stoneAxe);

        ShapelessCraft stoneShieldPlate = new ShapelessCraft(new ItemStack(Material.STONE_AXE)); // TODO ADD SHIELD
        stoneShieldPlate.addIngredient(CustomItems.getFromValue(CustomItems.STONE_SHIELD_PLATE));
        stoneShieldPlate.addIngredient(new ItemStack(Material.STICK));
        shapelessCrafts.add(stoneShieldPlate);

        CraftManager.removeCraft(Material.STONE_PICKAXE);
    }
}
