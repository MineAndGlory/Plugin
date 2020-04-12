package fr.fingarde.mineandglory.listeners;

import org.bukkit.Bukkit;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.block.data.Openable;
import org.bukkit.block.data.type.Door;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class DoubleDoorListener implements Listener
{
    @EventHandler
    public void onDoorClick(PlayerInteractEvent event)
    {
        Block c = event.getClickedBlock();
        BlockState s = c.getState();
        Openable d = (Door) s.getBlockData();
        d.setOpen(true);
        s.update();

        /*
        if(event.getClickedBlock() == null) return;
        Bukkit.broadcastMessage("1");
        if(!event.getClickedBlock().getType().toString().endsWith("_DOOR")) return;
        Bukkit.broadcastMessage("2");

        Door door = (Door) event.getClickedBlock().getBlockData();
        Door relative;

        if(event.getClickedBlock().getRelative(1, 0, 0).getType() == event.getClickedBlock().getType()) {
            Bukkit.broadcastMessage("3");
            relative = (Door) event.getClickedBlock().getRelative(1, 0, 0).getBlockData();
            if(relative.getHinge() != getInverse(door.getHinge())) {
                Bukkit.broadcastMessage("7");
                relative.setOpen(!relative.isOpen());
            }
        }
        if(event.getClickedBlock().getRelative(-1, 0, 0).getType() == event.getClickedBlock().getType()) {
            Bukkit.broadcastMessage("4");
            relative = (Door) event.getClickedBlock().getRelative(-1, 0, 0).getBlockData();
            if(relative.getHinge() != getInverse(door.getHinge())) {
                Bukkit.broadcastMessage("8");
                relative.setOpen(!door.isOpen());
            }
        }
        if(event.getClickedBlock().getRelative(0, 0, 1).getType() == event.getClickedBlock().getType()) {
            Bukkit.broadcastMessage("5");
            relative = (Door) event.getClickedBlock().getRelative(0, 0, 1).getBlockData();
            if(relative.getHinge() != getInverse(door.getHinge())) {
                Bukkit.broadcastMessage("9");
                relative.setOpen(!door.isOpen());
            }
        }
        if(event.getClickedBlock().getRelative(0, 0, -1).getType() == event.getClickedBlock().getType()) {
            Bukkit.broadcastMessage("6");
            relative = (Door) event.getClickedBlock().getRelative(0, 0, -1).getBlockData();
            if(relative.getHinge() != getInverse(door.getHinge())) {
                Bukkit.broadcastMessage("10");
                relative.setOpen(!door.isOpen());
            }
        }*/
    }

    public Door.Hinge getInverse(Door.Hinge hinge) {
        if(hinge == Door.Hinge.LEFT) return Door.Hinge.RIGHT;
        return Door.Hinge.LEFT;
    }
}
