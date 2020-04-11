package fr.fingarde.mineandglory.listeners;

import fr.fingarde.mineandglory.items.CustomItems;
import fr.fingarde.mineandglory.utils.ColorUtils;
import fr.fingarde.mineandglory.utils.Database;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.ItemMergeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.meta.ItemMeta;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BackpackListener implements Listener
{
    @EventHandler
    public void onClickWithRock(PlayerInteractEvent event)
    {
        Player player = event.getPlayer();

        if (event.getHand() != EquipmentSlot.HAND) return;

        if (event.getAction() != Action.RIGHT_CLICK_AIR) return;
        if (event.getItem() == null) return;

        if (event.getItem().getType() != Material.IRON_NUGGET) return;

        ItemMeta meta = event.getItem().getItemMeta();
        if (!event.getItem().getItemMeta().getLocalizedName().equals(CustomItems.BACKPACK.name()) && !event.getItem().getItemMeta().getLocalizedName().equals(CustomItems.BIG_BACKPACK.name())) return;

        UUID bagUUID = null;
        if(meta.getLore() != null)
        {
            for(String lore : meta.getLore()) {
                Bukkit.broadcastMessage(ColorUtils.removeColor(lore));
                if(ColorUtils.removeColor(lore).startsWith("ID: ")) {
                    Bukkit.broadcastMessage(lore.split(" ")[1]);
                    bagUUID = UUID.fromString(lore.split(" ")[1]);


                }
            }
        }

        if(bagUUID == null)
        {
            bagUUID = UUID.randomUUID();
            try (Connection connection = Database.getSource().getConnection();
                 Statement statement = connection.createStatement())
            {
                int size = (event.getItem().getItemMeta().getLocalizedName().equals(CustomItems.BACKPACK.name()) ? 18 : 36);
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

        Bukkit.broadcastMessage("bag oppened");
        try (Connection connection = Database.getSource().getConnection();
             Statement statement = connection.createStatement();
             ResultSet result = statement.executeQuery("") )
        {
            Bukkit.broadcastMessage("bag oppened");
        } catch (SQLException e)
        {
            e.printStackTrace();
        }

    }
}
