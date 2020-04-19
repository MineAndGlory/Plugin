package fr.fingarde.mineandglory.utils.managers;

import fr.fingarde.mineandglory.objects.LootTable;
import fr.fingarde.mineandglory.objects.LootTableRegister;
import fr.fingarde.mineandglory.objects.loottables.Crops;
import org.bukkit.inventory.ItemStack;

import java.util.Collection;
import java.util.HashMap;

public class LootTableManager
{
    public static HashMap<String, LootTable> lootTables = new HashMap<>();

    public static void registerLootTables() {
        register(new Crops());
    }


    private static void register(LootTableRegister register) {
        register.register();
    }

    public static void addLootTable(String name, LootTable lootTable) {
        lootTables.put(name, lootTable);
    }

    public Collection<ItemStack> getDrops() {

        return null;
    }


}
