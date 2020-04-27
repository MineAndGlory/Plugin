package fr.fingarde.mineandglory.objects.conditions;

import fr.fingarde.mineandglory.utils.RegexUtils;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class RegexConditionIgnoreCase implements Condition
    {
        private String regex;

    public RegexConditionIgnoreCase(String regex)
        {
            this.regex = regex.toLowerCase();
        }

        @Override
        public boolean isTrue(ItemStack itemStack)
        {
            if (itemStack == null) return false;
            if (RegexUtils.matching(regex, itemStack.getType().name().toLowerCase())) return true;

            ItemMeta meta = itemStack.getItemMeta();
            return (RegexUtils.matching(regex, meta.getLocalizedName().toLowerCase()));
        }

}
