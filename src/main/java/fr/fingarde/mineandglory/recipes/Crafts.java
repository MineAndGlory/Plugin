package fr.fingarde.mineandglory.recipes;

import fr.fingarde.mineandglory.Main;
import fr.fingarde.mineandglory.objects.items.CustomItems;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.*;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.*;

import static org.bukkit.Bukkit.getServer;

public class Crafts implements Listener
{
    public static List<ShapelessCraft> shapelessCrafts = new LinkedList<>();

    @EventHandler
    public void onPrepareCraft(PrepareItemCraftEvent event)
    {
        for (ShapelessCraft craft : shapelessCrafts)
        {
            if (craft.equals(event.getInventory().getMatrix()))
            {
                event.getInventory().setResult(craft.getResult());
                return;
            }
        }
    }

    @EventHandler
    public void onCraft(final InventoryClickEvent event)
    {
        if (event.getClickedInventory() == null) return;
        if (event.getClickedInventory().getType() != InventoryType.WORKBENCH) return;

        CraftingInventory inv = (CraftingInventory) event.getClickedInventory();

        if (event.getSlotType() != InventoryType.SlotType.RESULT) return;
        if (inv.getResult() == null) return;
        if (inv.getRecipe() != null) return;

        if (event.getCursor().getMaxStackSize() == 1) return;
        if (event.getCursor().getItemMeta() != null)
        {
            if (!event.getCursor().getItemMeta().getLocalizedName().equals(""))
            {
                if (CustomItems.valueOf(event.getCursor().getItemMeta().getLocalizedName()).getMaxStack() == 1) return;
            }
        }

        if (event.getClick().name().startsWith("SHIFT"))
        {
            event.setCancelled(true);
            return;
        }

        new BukkitRunnable()
        {
            @Override
            public void run()
            {
                for (ItemStack item : inv.getMatrix())
                {
                    if (item == null) continue;

                    item.setAmount(item.getAmount() / 2);
                }
            }
        }.runTaskLater(Main.getPlugin(), 0);
    }
}
