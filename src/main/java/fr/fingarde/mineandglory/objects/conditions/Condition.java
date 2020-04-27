package fr.fingarde.mineandglory.objects.conditions;

import org.bukkit.inventory.ItemStack;

public interface Condition
{
    boolean isTrue(ItemStack itemStack);
}