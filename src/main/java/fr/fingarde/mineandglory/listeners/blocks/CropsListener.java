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
        if (event.getAction() != Action.RIGHT_CLICK_BLOCK) return;
        if (event.getPlayer().isSneaking()) return;

        if (event.getClickedBlock() == null) return;
        if (!isCrop(event.getClickedBlock().getType())) return;

        Ageable ageable = (Ageable) event.getClickedBlock().getBlockData();

        Material type = event.getClickedBlock().getType();
        String e;

        switch (type)
        {
            case CARROTS:
                if (ageable.getAge() == 7)
                    e = "carrot";
                else
                    e = "tomato";
                break;
            case WHEAT:
                if (ageable.getAge() == 7)
                    e = "wheat";
                else
                    e = "rice";
                break;
            case POTATOES:
                if (ageable.getAge() == 7)
                    e = "potato";
                else
                    e = "lettuce";
                break;
            case BEETROOT:
                if (ageable.getAge() == 3)
                    e = "raspberry";
                else
                    e = "strawberry";
                break;
            default:
                return;
        }

        LootTableManager.getDrops(e, event.getItem()).forEach(itemStack -> event.getPlayer().getWorld().dropItem(event.getClickedBlock().getLocation(), itemStack));

        if(isBush(type)) ageable.setAge(ageable.getAge() - 3);
        else ageable.setAge(ageable.getAge() - 6);

        event.getClickedBlock().setBlockData(ageable);
    }

    private boolean isBush(Material material)
    {
        return material == Material.BEETROOTS;
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
