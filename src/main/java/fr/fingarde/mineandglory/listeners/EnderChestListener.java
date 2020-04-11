package fr.fingarde.mineandglory.listeners;

import fr.fingarde.mineandglory.items.CustomItems;
import fr.fingarde.mineandglory.utils.Database;
import fr.fingarde.mineandglory.utils.ItemSerializer;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.Inventory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EnderChestListener implements Listener
{

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        if(event.getAction() != Action.RIGHT_CLICK_BLOCK) return;

        if(event.getClickedBlock().getType() != Material.ENDER_CHEST) return;

        event.setCancelled(true);
        try (Connection connection = Database.getSource().getConnection();
             Statement statement = connection.createStatement();
             ResultSet result = statement.executeQuery("SELECT * FROM tb_enderchest WHERE ec_player = '" + event.getPlayer().getUniqueId().toString() + "'"))
        {
            result.next();

            Inventory inv = Bukkit.createInventory(null, 36, "Enderchest");

            if(result.getString("ec_items") != null) {
                inv.setContents(ItemSerializer.deserializeArray(result.getString("ec_items")));
            }

            for(int i = result.getInt("ec_size") - 1; i < 36; i++) {
                inv.getItem(i).setType(Material.BARRIER);
            }

            event.getPlayer().openInventory(inv);
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
    @EventHandler
    public void onClick(PlayerInteractEvent event)
    {
        Player player = event.getPlayer();

        if (event.getHand() != EquipmentSlot.HAND) return;

        if (event.getAction() != Action.RIGHT_CLICK_AIR) return;
        if (event.getItem() == null) return;

        if (event.getItem().getType() != Material.IRON_NUGGET) return;

        if (!event.getItem().getItemMeta().getLocalizedName().equals(CustomItems.ENDER_BACKPACK.name())) return;

        try (Connection connection = Database.getSource().getConnection();
             Statement statement = connection.createStatement();
             ResultSet result = statement.executeQuery("SELECT * FROM tb_enderchest WHERE ec_player = '" + player.getUniqueId().toString() + "'"))
        {
            result.next();

            Inventory inv = Bukkit.createInventory(null, 36, "Enderchest");

            if(result.getString("ec_items") != null) {
                inv.setContents(ItemSerializer.deserializeArray(result.getString("ec_items")));
            }

            player.openInventory(inv);
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    @EventHandler
    public void onClose(InventoryCloseEvent event) {
        if(!event.getView().getTitle().startsWith("Enderchest")) return;

        try (Connection connection = Database.getSource().getConnection();
             Statement statement = connection.createStatement()
        )
        {
            event.getInventory().remove(Material.BARRIER);
            statement.executeUpdate("UPDATE tb_enderchest SET ec_items = '" + ItemSerializer.serializeArray(event.getInventory().getContents()) + "' WHERE ec_player = '" + event.getPlayer().getUniqueId().toString() + "'");
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
