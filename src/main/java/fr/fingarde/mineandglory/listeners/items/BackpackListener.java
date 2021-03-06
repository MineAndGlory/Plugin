package fr.fingarde.mineandglory.listeners.items;

import fr.fingarde.mineandglory.objects.items.CustomItems;
import fr.fingarde.mineandglory.utils.ColorUtils;
import fr.fingarde.mineandglory.utils.storage.Database;
import fr.fingarde.mineandglory.utils.serializer.ItemSerializer;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.*;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.meta.ItemMeta;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static fr.fingarde.mineandglory.objects.items.CustomItems.*;

public class BackpackListener implements Listener
{

    @EventHandler
    public void onClick(PlayerInteractEvent event)
    {
        Player player = event.getPlayer();

        if (event.getHand() != EquipmentSlot.HAND) return;

        if (event.getAction() != Action.RIGHT_CLICK_AIR) return;
        if (event.getItem() == null) return;

        ItemMeta meta = event.getItem().getItemMeta();
        if (!meta.getLocalizedName().equals(BACKPACK.name()) && !meta.getLocalizedName().equals(BIG_BACKPACK.name()))
            return;

        UUID bagUUID = null;
        if (meta.getLore() != null)
        {
            for (String lore : meta.getLore())
            {
                if (ColorUtils.removeColor(lore).startsWith("ID: "))
                {
                    bagUUID = UUID.fromString(lore.split(" ")[1]);
                    break;
                }
            }
        }

        if (bagUUID == null)
        {
            bagUUID = UUID.randomUUID();
            try (Connection connection = Database.getSource().getConnection();
                 Statement statement = connection.createStatement())
            {
                int size = (event.getItem().getItemMeta().getLocalizedName().equals(BACKPACK.name()) ? 18 : 36);
                statement.executeUpdate("INSERT INTO tb_backpack(bp_id, bp_size) VALUES('" + bagUUID.toString() + "', '" + size + "')");

                List<String> lore = event.getItem().getItemMeta().getLore();
                if (lore == null) lore = new ArrayList<>();

                lore.add("§eID: " + bagUUID.toString());
                meta.setLore(lore);
                event.getItem().setItemMeta(meta);
            } catch (SQLException e)
            {
                e.printStackTrace();
            }
        }

        try (Connection connection = Database.getSource().getConnection();
             Statement statement = connection.createStatement();
             ResultSet result = statement.executeQuery("SELECT * FROM tb_backpack WHERE bp_id = '" + bagUUID.toString() + "'"))
        {
            result.next();

            Inventory inv = Bukkit.createInventory(null, result.getInt("bp_size"), "Backpack " + ColorUtils.hideChars(bagUUID.toString()));

            if (result.getString("bp_items") != null)
            {
                inv.setContents(ItemSerializer.deserializeArray(result.getString("bp_items")));
            }

            player.openInventory(inv);
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    @EventHandler
    public void onClickNumber(InventoryClickEvent event)
    {
        if (event.getClick() != ClickType.NUMBER_KEY) return;
        if (!event.getWhoClicked().getOpenInventory().getTitle().startsWith("Backpack")) return;

        if (event.getWhoClicked().getInventory().getItem(event.getHotbarButton()) == null) return;
        if (!event.getWhoClicked().getInventory().getItem(event.getHotbarButton()).getItemMeta().getLocalizedName().equals(BACKPACK.name()) && !event.getWhoClicked().getInventory().getItem(event.getHotbarButton()).getItemMeta().getLocalizedName().equals(BIG_BACKPACK.name()))
            return;

        event.setCancelled(true);
        ((Player) event.getWhoClicked()).updateInventory();
    }

    @EventHandler
    public void onClickNumberCancel(InventoryClickEvent event)
    {
        if (event.getCurrentItem() == null) return;
        if (!event.getView().getTitle().startsWith("Backpack")) return;

        if (!event.getCurrentItem().getItemMeta().getLocalizedName().equals(BACKPACK.name()) && !event.getCurrentItem().getItemMeta().getLocalizedName().equals(BIG_BACKPACK.name()))
            return;

        event.setCancelled(true);
        ((Player) event.getWhoClicked()).updateInventory();
    }

    @EventHandler
    public void onClose(InventoryCloseEvent event)
    {
        if (!event.getView().getTitle().startsWith("Backpack")) return;
        UUID bagUUID = UUID.fromString(ColorUtils.unhideChars(event.getView().getTitle().split(" ")[1]));

        try (Connection connection = Database.getSource().getConnection();
             Statement statement = connection.createStatement()
        )
        {
            statement.executeUpdate("UPDATE tb_backpack SET bp_items = '" + ItemSerializer.serializeArray(event.getInventory().getContents()) + "' WHERE bp_id = '" + bagUUID + "'");
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
