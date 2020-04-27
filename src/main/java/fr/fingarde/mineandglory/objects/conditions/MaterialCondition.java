package fr.fingarde.mineandglory.objects.conditions;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

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