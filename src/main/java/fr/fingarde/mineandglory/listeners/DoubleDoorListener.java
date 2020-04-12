package fr.fingarde.mineandglory.listeners;

import org.bukkit.block.data.type.Door;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class DoubleDoorListener implements Listener
{
    @EventHandler
    public void onDoorClick(PlayerInteractEvent event)
    {
        if(event.getClickedBlock() == null) return;
        if(!event.getClickedBlock().getType().toString().endsWith("_DOOR")) return;

        Door door = (Door) event.getClickedBlock().getState();
        Door relative;
        if(event.getClickedBlock().getRelative(1, 0, 0).getType() == event.getClickedBlock().getType()) {
            relative = (Door) event.getClickedBlock().getRelative(1, 0, 0).getState();
            if(relative.getHinge() != getInverse(door.getHinge())) {
                relative.setOpen(door.isOpen());
            }
        }
        if(event.getClickedBlock().getRelative(-1, 0, 0).getType() == event.getClickedBlock().getType()) {
            relative = (Door) event.getClickedBlock().getRelative(-1, 0, 0).getState();
            if(relative.getHinge() != getInverse(door.getHinge())) {
                relative.setOpen(door.isOpen());
            }
        }
        if(event.getClickedBlock().getRelative(0, 0, 1).getType() == event.getClickedBlock().getType()) {
            relative = (Door) event.getClickedBlock().getRelative(0, 0, 1).getState();
            if(relative.getHinge() != getInverse(door.getHinge())) {
                relative.setOpen(door.isOpen());
            }
        }
        if(event.getClickedBlock().getRelative(0, 0, -1).getType() == event.getClickedBlock().getType()) {
            relative = (Door) event.getClickedBlock().getRelative(0, 0, -1).getState();
            if(relative.getHinge() != getInverse(door.getHinge())) {
                relative.setOpen(door.isOpen());
            }
        }
    }

    public Door.Hinge getInverse(Door.Hinge hinge) {
        if(hinge == Door.Hinge.LEFT) return Door.Hinge.RIGHT;
        return Door.Hinge.LEFT;
    }
}
