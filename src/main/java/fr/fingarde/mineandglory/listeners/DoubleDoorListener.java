package fr.fingarde.mineandglory.listeners;

import org.bukkit.Bukkit;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.block.data.type.Door;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockPhysicsEvent;
import org.bukkit.event.block.BlockRedstoneEvent;
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

        Block relative;
        switch (state.getFacing()) {
            case EAST:
                if(state.getHinge() == Door.Hinge.RIGHT)
                    relative = block.getRelative(0, 0, -1);
                else
                    relative = block.getRelative(0, 0, 1);
                break;
            case WEST:
                if(state.getHinge() == Door.Hinge.RIGHT)
                    relative = block.getRelative(0, 0, 1);
                else
                    relative = block.getRelative(0, 0, -1);
                break;
            case NORTH:
                if(state.getHinge() == Door.Hinge.RIGHT)
                    relative = block.getRelative(-1, 0, 0);
                else
                    relative = block.getRelative(1, 0, 0);
                break;
            case SOUTH:
                if(state.getHinge() == Door.Hinge.RIGHT)
                    relative = block.getRelative(1, 0, 0);
                else
                    relative = block.getRelative(-1, 0, 0);
                break;
            default:
                relative = null;
        }

        if (relative == null) return;
        Door relativeState = (Door) relative.getBlockData();

        if(relativeState.getHinge() == state.getHinge()) return;

        relativeState.setOpen(!state.isOpen());
        relative.setBlockData(relativeState);
    }

    @EventHandler
    public void onRedstone(BlockPhysicsEvent event) {
        if (!event.getBlock().getType().toString().endsWith("_DOOR")) return;

        Bukkit.broadcastMessage("ui");
        Block block = event.getBlock();
        Door state = (Door) event.getBlock().getBlockData();

        Block relative;
        switch (state.getFacing()) {
            case EAST:
                if(state.getHinge() == Door.Hinge.RIGHT)
                    relative = block.getRelative(0, 0, -1);
                else
                    relative = block.getRelative(0, 0, 1);
                break;
            case WEST:
                if(state.getHinge() == Door.Hinge.RIGHT)
                    relative = block.getRelative(0, 0, 1);
                else
                    relative = block.getRelative(0, 0, -1);
                break;
            case NORTH:
                if(state.getHinge() == Door.Hinge.RIGHT)
                    relative = block.getRelative(-1, 0, 0);
                else
                    relative = block.getRelative(1, 0, 0);
                break;
            case SOUTH:
                if(state.getHinge() == Door.Hinge.RIGHT)
                    relative = block.getRelative(1, 0, 0);
                else
                    relative = block.getRelative(-1, 0, 0);
                break;
            default:
                relative = null;
        }

        if (relative == null) return;
        Door relativeState = (Door) relative.getBlockData();

        if(relativeState.getHinge() == state.getHinge()) return;

        relativeState.setOpen(!state.isOpen());
        relative.setBlockData(relativeState);
    }
}
