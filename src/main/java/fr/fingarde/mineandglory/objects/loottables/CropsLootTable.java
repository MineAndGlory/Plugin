package fr.fingarde.mineandglory.objects.loottables;

        import fr.fingarde.mineandglory.objects.LootTable;
        import fr.fingarde.mineandglory.objects.LootTableRegister;
        import fr.fingarde.mineandglory.objects.items.CustomItems;
        import fr.fingarde.mineandglory.utils.managers.LootTableManager;
        import org.bukkit.Material;
        import org.bukkit.enchantments.Enchantment;
        import org.bukkit.inventory.ItemStack;

public class CropsLootTable implements LootTableRegister
{
    @Override
    public void register()
    {
        LootTableManager.addLootTable("tomato", new LootTable()
                .addEntry(new LootTable.Entry(CustomItems.getFromValue(CustomItems.TOMATO))
                        .setChance(1)
                        .setMax(10)
                        .setMin(1)));
        LootTableManager.addLootTable("test", new LootTable()
                .addEntry(new LootTable.Entry(CustomItems.getFromValue(CustomItems.VILLAGER_COIN))
                        .setChance(1)
                        .setMax(10)
                        .setMin(1)
                        .addCondition(new LootTable.EnchantCondition(Enchantment.SILK_TOUCH)))
                .addEntry(new LootTable.Entry(new ItemStack(Material.STONE))
                        .setChance(1)
                        .setMax(10)
                        .setMin(1)));
    }
}
