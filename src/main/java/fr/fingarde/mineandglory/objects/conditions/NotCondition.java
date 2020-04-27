package fr.fingarde.mineandglory.objects.conditions;

import org.bukkit.inventory.ItemStack;

public class NotCondition implements Condition
{
    private Condition condition;

    public NotCondition(Condition condition)
    {
        this.condition = condition;
    }

    @Override
    public boolean isTrue(ItemStack itemStack)
    {
        return !condition.isTrue(itemStack);
    }
}
