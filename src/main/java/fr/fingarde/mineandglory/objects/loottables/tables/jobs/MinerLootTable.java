package fr.fingarde.mineandglory.objects.loottables.tables.jobs;

import fr.fingarde.mineandglory.objects.conditions.EnchantCondition;
import fr.fingarde.mineandglory.objects.conditions.NotCondition;
import fr.fingarde.mineandglory.objects.conditions.RegexConditionIgnoreCase;
import fr.fingarde.mineandglory.objects.loottables.LootTableRegister;
import fr.fingarde.mineandglory.objects.items.CustomItems;
import fr.fingarde.mineandglory.objects.loottables.LootTable;
import fr.fingarde.mineandglory.utils.managers.LootTableManager;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

public class MinerLootTable implements LootTableRegister
{
    @Override
    public void register()
    {
        LootTableManager.addLootTable("stone", new LootTable()
                .addEntry(new LootTable.Entry(CustomItems.getFromValue(CustomItems.ROCK))
                        .setChance(1)
                        .setMax(10)
                        .setMin(1)
                        .addCondition(new NotCondition(new RegexConditionIgnoreCase("pickaxe$"))))
                .addEntry(new LootTable.Entry(new ItemStack(Material.STONE))
                        .setChance(1)
                        .setMax(10)
                        .setMin(1)
                        .addCondition(new RegexConditionIgnoreCase("pickaxe$"))
                        .addCondition(new EnchantCondition(Enchantment.SILK_TOUCH)))
                .addEntry(new LootTable.Entry(new ItemStack(Material.COBBLESTONE))
                        .setChance(1)
                        .setMax(10)
                        .setMin(1)
                        .addCondition(new RegexConditionIgnoreCase("pickaxe$"))
                        .addCondition(new NotCondition(new EnchantCondition(Enchantment.SILK_TOUCH)))));
    }
}
