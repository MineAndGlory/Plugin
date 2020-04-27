package fr.fingarde.mineandglory.objects.loottables.tables.jobs;

import fr.fingarde.mineandglory.objects.conditions.NotCondition;
import fr.fingarde.mineandglory.objects.conditions.RegexConditionIgnoreCase;
import fr.fingarde.mineandglory.objects.loottables.LootTable;
import fr.fingarde.mineandglory.objects.loottables.LootTableRegister;
import fr.fingarde.mineandglory.utils.managers.LootTableManager;

import static fr.fingarde.mineandglory.objects.items.CustomItems.ROCK;
import static fr.fingarde.mineandglory.objects.items.CustomItems.getFromValue;

public class MinerLootTable implements LootTableRegister
{
    @Override
    public void register()
    {
        LootTableManager.addLootTable("stone", new LootTable()
                .addEntry(new LootTable.Entry(getFromValue(ROCK))
                        .setChance(1)
                        .setMax(10)
                        .setMin(1)
                        .addCondition(new NotCondition(new RegexConditionIgnoreCase("_pickaxe$")))));
    }
}
