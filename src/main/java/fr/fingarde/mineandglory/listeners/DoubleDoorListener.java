package fr.fingarde.mineandglory.listeners;

import org.bukkit.Bukkit;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.block.data.type.Door;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class DoubleDoorListener implements Listener
{
    @EventHandler
    public void onDoorClick(PlayerInteractEvent event)
    {
        if (event.getClickedBlock() == null) return;
        Bukkit.broadcastMessage("1");
        if (!event.getClickedBlock().getType().toString().endsWith("_DOOR")) return;
        Bukkit.broadcastMessage("2");

        Block block = event.getClickedBlock();
        Block relative = null;

        Door state = (Door) event.getClickedBlock().getBlockData();
        Door relativeState;

        if (block.getRelative(1, 0, 0).getType() == block.getType() && ((Door) block.getRelative(1, 0, 0).getBlockData()).getHinge() != state.getHinge())
        {
            relative = block.getRelative(1, 0, 0);
        } else if (block.getRelative(-1, 0, 0).getType() == block.getType() && ((Door) block.getRelative(-1, 0, 0).getBlockData()).getHinge() != state.getHinge())
        {
            relative = block.getRelative(-1, 0, 0);
        }
        else if (block.getRelative(0, 0, 1).getType() == block.getType() && ((Door) block.getRelative(0, 0, 1).getBlockData()).getHinge() != state.getHinge())
        {
            relative = block.getRelative(0, 0, 1);
        }
        else if (block.getRelative(0, 0, -1).getType() == block.getType() && ((Door) block.getRelative(0, 0, -1).getBlockData()).getHinge() != state.getHinge())
        {
            relative = block.getRelative(0, 0, -1);
        }

        if(relative == null) return;

        relativeState = (Door) relative.getBlockData();
        relativeState.setOpen(state.isOpen());
        relative.setBlockData(relativeState);
    }
}
