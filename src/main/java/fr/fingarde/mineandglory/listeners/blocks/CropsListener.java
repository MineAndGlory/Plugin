package fr.fingarde.mineandglory.listeners.blocks;

import fr.fingarde.mineandglory.objects.blocks.CustomBlocks;
import fr.fingarde.mineandglory.utils.managers.LootTableManager;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.Ageable;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockGrowEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class CropsListener implements Listener
{
    @EventHandler
    public void onGrow(BlockGrowEvent event)
    {
        Block block = event.getBlock();
        Ageable ageable = (Ageable) block.getBlockData();

        if (!isCrop(block.getType())) return;

        event.setCancelled(true);
        if (ageable.getAge() + 1 == ageable.getMaximumAge())
        {
            return;
        }

        ageable.setAge(ageable.getAge() + 2);

        block.setBlockData(ageable);
    }

    @EventHandler
    public void onClick(PlayerInteractEvent event)
    {
        if(event.getAction() != Action.RIGHT_CLICK_BLOCK) return;

        if(event.getClickedBlock() == null) return;
        if(event.getClickedBlock().getType() != Material.CARROTS) return;

        Ageable ageable = (Ageable) event.getClickedBlock().getBlockData();
        if(ageable.getAge() != CustomBlocks.TOMATO_STAGE3.getData().get("age").getAsInt()) return;

        LootTableManager.getDrops("tomato", event.getItem()).forEach(itemStack -> event.getPlayer().getWorld().dropItem(event.getClickedBlock().getLocation(), itemStack));

        ageable.setAge(CustomBlocks.TOMATO_STAGE0.getData().get("age").getAsInt());

        event.getClickedBlock().setBlockData(ageable);
    }

    private boolean isCrop(Material material)
    {
        switch (material)
        {
            case WHEAT:
            case POTATOES:
            case CARROTS:
            case BEETROOTS:
                return true;
        }

        return false;
    }
}
