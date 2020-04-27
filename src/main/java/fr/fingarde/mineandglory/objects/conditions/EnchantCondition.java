package fr.fingarde.mineandglory.objects.conditions;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class EnchantCondition implements Condition
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