package fr.fingarde.mineandglory.listeners;

import org.bukkit.Bukkit;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.block.data.type.Door;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class DoubleDoorListener implements Listener
{
    @EventHandler
    public void onDoorClick(PlayerInteractEvent event)
    {
        if(event.getAction() != Action.RIGHT_CLICK_BLOCK) return;
        if (!event.getClickedBlock().getType().toString().endsWith("_DOOR")) return;

        Block block = event.getClickedBlock();


        Door state = (Door) event.getClickedBlock().getBlockData();
        /*
        Block relative = null;
        Door relativeState;

        if (block.getRelative(1, 0, 0).getType() == block.getType() && ((Door) block.getRelative(1, 0, 0).getBlockData()).getHinge() != state.getHinge())
        {
            relative = block.getRelative(1, 0, 0);
        } else if (block.getRelative(-1, 0, 0).getType() == block.getType() && ((Door) block.getRelative(-1, 0, 0).getBlockData()).getHinge() != state.getHinge())
        {
            relative = block.getRelative(-1, 0, 0);
        } else if (block.getRelative(0, 0, 1).getType() == block.getType() && ((Door) block.getRelative(0, 0, 1).getBlockData()).getHinge() != state.getHinge())
        {
            relative = block.getRelative(0, 0, 1);
        } else if (block.getRelative(0, 0, -1).getType() == block.getType() && ((Door) block.getRelative(0, 0, -1).getBlockData()).getHinge() != state.getHinge())
        {
            relative = block.getRelative(0, 0, -1);
        }

        if (relative == null) return;

        relativeState = (Door) relative.getBlockData();
        relativeState.setOpen(!state.isOpen());
        relative.setBlockData(relativeState);*/



        Block relative;
        switch (state.getFacing()) {
            case EAST:
            case WEST:
                if(state.getHinge() == Door.Hinge.RIGHT)
                    relative = block.getRelative(0, 0, -1);
                else
                    relative = block.getRelative(0, 0, 1);
                break;
            default:
                relative = null;
        }

        if (relative == null) return;

        Door relativeState = (Door) relative.getBlockData();
        relativeState.setOpen(!state.isOpen());
        relative.setBlockData(relativeState);
    }


}
