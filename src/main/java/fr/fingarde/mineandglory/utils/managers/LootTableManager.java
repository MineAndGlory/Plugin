package fr.fingarde.mineandglory.utils.managers;

import fr.fingarde.mineandglory.objects.loottables.LootTable;
import fr.fingarde.mineandglory.objects.loottables.LootTableRegister;
import fr.fingarde.mineandglory.objects.loottables.tables.CropsLootTable;
import fr.fingarde.mineandglory.objects.loottables.tables.jobs.MinerLootTable;
import fr.fingarde.mineandglory.objects.loottables.tables.jobs.WoodcutterLootTable;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.List;

public class LootTableManager
{
    private static HashMap<String, LootTable> lootTables = new HashMap<>();

    public static void registerLootTables()
    {
        register(new CropsLootTable());
        register(new MinerLootTable());
        register(new WoodcutterLootTable());
    }

    private static void register(LootTableRegister register)
    {
        register.register();
    }

    public static void addLootTable(String name, LootTable lootTable)
    {
        lootTables.put(name, lootTable);
    }

    public static List<ItemStack> getDrops(String lootTableName, ItemStack itemStack)
    {
        if(!lootTables.containsKey(lootTableName.toLowerCase())) return null;

        LootTable lootTable = lootTables.get(lootTableName);

        return lootTable.getLoot(itemStack);
    }
}
