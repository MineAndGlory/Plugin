package fr.fingarde.mineandglory.objects.loottables.tables.jobs;

import fr.fingarde.mineandglory.objects.conditions.NotCondition;
import fr.fingarde.mineandglory.objects.conditions.RegexConditionIgnoreCase;
import fr.fingarde.mineandglory.objects.loottables.LootTable;
import fr.fingarde.mineandglory.objects.loottables.LootTableRegister;
import fr.fingarde.mineandglory.utils.managers.LootTableManager;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class WoodcutterLootTable implements LootTableRegister
{

    @Override
    public void register()
    {
        LootTableManager.addLootTable("log", new LootTable()
                .addEntry(new LootTable.Entry(new ItemStack(Material.STICK))
                        .setChance(1)
                        .setMax(10)
                        .setMin(1)
                        .addCondition(new NotCondition(new RegexConditionIgnoreCase("pickaxe$")))));
    }
}
