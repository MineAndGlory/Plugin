package fr.fingarde.mineandglory.recipes;

import fr.fingarde.mineandglory.Main;
import fr.fingarde.mineandglory.items.CustomItems;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.*;
import org.bukkit.material.MaterialData;
import org.bukkit.scheduler.BukkitRunnable;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Crafts implements Listener {
    public static List<ShapelessCraft> shapelessCrafts = new LinkedList<>();
    public static Main plugin = Main.getPlugin();

    public static void registerCrafts() {
        stoneCrafts();
    }

    private static void stoneCrafts() {
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

        Main.getPlugin().getServer().removeRecipe(NamespacedKey.minecraft("stone_pickaxe"));
    }

    @EventHandler
    public void onPrepareCraft(PrepareItemCraftEvent event) {
        for(ShapelessCraft craft : shapelessCrafts) {
            if (craft.equals(event.getInventory().getMatrix())) {
                event.getInventory().setResult(craft.getResult());
                return;
            }
        }
    }

    @EventHandler
    public void onCraft(final InventoryClickEvent event) {
        if(event.getClickedInventory().getType() != InventoryType.WORKBENCH) return;

        final CraftingInventory inv = (CraftingInventory) event.getClickedInventory();

        if(event.getSlotType() != InventoryType.SlotType.RESULT) return;
        if(inv.getResult() == null) return;
        if(inv.getRecipe() != null) return;

        if(event.getCursor().getMaxStackSize() == 1) return;
        if(event.getCursor().getItemMeta() != null) {
            if (!event.getCursor().getItemMeta().getLocalizedName().equals("")) {
                if (CustomItems.valueOf(event.getCursor().getItemMeta().getLocalizedName()).getMaxStack() == 1) return;
            }
        }

        if(event.getClick().name().startsWith("SHIFT")) {
            event.setCancelled(true);
            return;
        }

        new BukkitRunnable() {
            @Override
            public void run() {
                for(ItemStack item : inv.getMatrix()) {
                    if(item == null) continue;

                    item.setAmount(item.getAmount() / 2);
                }
            }
        }.runTaskLater(Main.getPlugin(), 0);
    }
}
