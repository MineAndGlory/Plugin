package fr.fingarde.mineandglory.listeners.blocks;

import fr.fingarde.mineandglory.utils.managers.LootTableManager;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class PlayerBreakBlockByHandListener implements Listener
{
    @EventHandler
    public void onBreakStone(BlockBreakEvent event)
    {
        if (event.getBlock().getType() != Material.STONE) return;
        if (event.getPlayer().getGameMode() == GameMode.CREATIVE) return;

        List<ItemStack> drops = LootTableManager.getDrops("stone", event.getPlayer().getInventory().getItemInMainHand());
        if (drops == null) return;

        event.setDropItems(false);
        drops.forEach(itemStack -> event.getPlayer().getWorld().dropItem(event.getBlock().getLocation(), itemStack));
    }

    @EventHandler
    public void onBreakWood(BlockBreakEvent event)
    {
        if (!event.getBlock().getType().name().endsWith("_LOG")) return;
        if (event.getPlayer().getInventory().getItemInMainHand().getType().name().endsWith("_AXE")) return;
        if (event.getPlayer().getGameMode() == GameMode.CREATIVE) return;

        List<ItemStack> drops = LootTableManager.getDrops("log", event.getPlayer().getInventory().getItemInMainHand());
        if (drops == null) return;

        event.setDropItems(false);
        drops.forEach(itemStack -> event.getPlayer().getWorld().dropItem(event.getBlock().getLocation(), itemStack));
    }
}
