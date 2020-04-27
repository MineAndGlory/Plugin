package fr.fingarde.mineandglory.objects.loottables.tables;

        import fr.fingarde.mineandglory.objects.conditions.EnchantCondition;
        import fr.fingarde.mineandglory.objects.loottables.LootTableRegister;
        import fr.fingarde.mineandglory.objects.items.CustomItems;
        import fr.fingarde.mineandglory.objects.loottables.LootTable;
        import fr.fingarde.mineandglory.utils.managers.LootTableManager;
        import org.bukkit.Material;
        import org.bukkit.enchantments.Enchantment;
        import org.bukkit.inventory.ItemStack;

public class CropsLootTable implements LootTableRegister
{
    @Override
    public void register()
    {
        LootTableManager.addLootTable("carrot", new LootTable()
                .addEntry(new LootTable.Entry(new ItemStack(Material.CARROT))
                        .setChance(1)
                        .setMax(10)
                        .setMin(1)));
        LootTableManager.addLootTable("tomato", new LootTable()
                .addEntry(new LootTable.Entry(CustomItems.getFromValue(CustomItems.TOMATO))
                        .setChance(1)
                        .setMax(10)
                        .setMin(1)));
        LootTableManager.addLootTable("wheat", new LootTable()
                .addEntry(new LootTable.Entry(new ItemStack(Material.WHEAT))
                        .setChance(1)
                        .setMax(10)
                        .setMin(1)));
        LootTableManager.addLootTable("rice", new LootTable()
                .addEntry(new LootTable.Entry(CustomItems.getFromValue(CustomItems.RICE))
                        .setChance(1)
                        .setMax(10)
                        .setMin(1)));
        LootTableManager.addLootTable("potato", new LootTable()
                .addEntry(new LootTable.Entry(new ItemStack(Material.POTATO))
                        .setChance(1)
                        .setMax(10)
                        .setMin(1)));
        LootTableManager.addLootTable("lettuce", new LootTable()
                .addEntry(new LootTable.Entry(CustomItems.getFromValue(CustomItems.LETTUCE))
                        .setChance(1)
                        .setMax(10)
                        .setMin(1)));
        LootTableManager.addLootTable("strawberry", new LootTable()
                .addEntry(new LootTable.Entry(CustomItems.getFromValue(CustomItems.STRAWBERRY))
                        .setChance(1)
                        .setMax(10)
                        .setMin(1)));
        LootTableManager.addLootTable("raspberry", new LootTable()
                .addEntry(new LootTable.Entry(CustomItems.getFromValue(CustomItems.RASPBERRY))
                        .setChance(1)
                        .setMax(10)
                        .setMin(1)));

        LootTableManager.addLootTable("test", new LootTable()
                .addEntry(new LootTable.Entry(CustomItems.getFromValue(CustomItems.VILLAGER_COIN))
                        .setChance(1)
                        .setMax(10)
                        .setMin(1)
                        .addCondition(new EnchantCondition(Enchantment.SILK_TOUCH)))
                .addEntry(new LootTable.Entry(new ItemStack(Material.STONE))
                        .setChance(1)
                        .setMax(10)
                        .setMin(1)));
    }
}
