package fr.fingarde.mineandglory.objects;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.LinkedList;
import java.util.List;

public class LootTable
{
    public interface Condition
    {
        boolean isTrue(ItemStack itemStack);
    }

    public static class EnchantCondition implements Condition
    {
        private Enchantment enchantment;

        public EnchantCondition(Enchantment enchantment)
        {
            this.enchantment = enchantment;
        }

        @Override
        public boolean isTrue(ItemStack itemStack)
        {
            if (itemStack == null) return false;

            ItemMeta meta = itemStack.getItemMeta();
            return meta.hasEnchant(enchantment);
        }
    }

    public class MaterialCondition implements Condition
    {
        private String material;

        public MaterialCondition(String material)
        {
            this.material = material;
        }

        @Override
        public boolean isTrue(ItemStack itemStack)
        {
            if (itemStack == null) return false;
            if (itemStack.getType().name().equals(material)) return true;
            ItemMeta meta = itemStack.getItemMeta();

            return meta.getLocalizedName().equals(material);
        }
    }

    public static class Entry
    {
        private ItemStack item;
        private List<Condition> conditions;

        private int min;
        private int max;
        private float chance;

        public Entry(ItemStack item)
        {
            this.item = item;
            this.conditions = new LinkedList<>();
        }

        public ItemStack getItem()
        {
            return item;
        }

        public List<Condition> getConditions()
        {
            return conditions;
        }

        public int getMin()
        {
            return min;
        }

        public int getMax()
        {
            return max;
        }

        public float getChance()
        {
            return chance;
        }

        public Entry addCondition(Condition condition)
        {
            conditions.add(condition);
            return this;
        }

        public Entry setMin(int min)
        {
            this.min = min;
            return this;
        }

        public Entry setMax(int max)
        {
            this.max = max;
            return this;
        }

        public Entry setChance(float chance)
        {
            this.chance = chance;
            return this;
        }
    }

    private List<Entry> entries = new LinkedList<>();

    public LootTable addEntry(Entry entry)
    {
        entries.add(entry);
        return this;
    }
}
