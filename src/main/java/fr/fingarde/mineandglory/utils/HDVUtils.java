package fr.fingarde.mineandglory.utils;

import fr.fingarde.mineandglory.Main;
import fr.fingarde.mineandglory.utils.serializer.ItemSerializer;
import fr.fingarde.mineandglory.utils.storage.Database;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import static fr.fingarde.mineandglory.objects.items.CustomItems.*;

public class HDVUtils
{
    public static void openPage(int page, Player player)
    {
        Inventory inv = Bukkit.createInventory(null, 54, "Hotel des ventes - page N°" + page);

        new BukkitRunnable()
        {
            @Override
            public void run()
            {
                try (
                        Connection connection = Database.getSource().getConnection();
                        Statement statement = connection.createStatement();

                        ResultSet result = statement.executeQuery("SELECT * FROM tb_market ORDER BY mk_date DESC LIMIT " + (page * 36) + ",36"))
                {
                    int nbItems = 0;
                    while (result.next())
                    {
                        ItemStack item = ItemSerializer.deserializeItem(result.getString("mk_item"));
                        ItemMeta meta = item.getItemMeta();
                        List<String> lore = new LinkedList<>();

                        lore.add("§ePrix " + result.getFloat("mk_price") + "$");

                        if(meta.getLore() != null) lore.addAll(meta.getLore());

                        meta.setLore(lore);
                        item.setItemMeta(meta);

                        inv.setItem(nbItems, item);
                        nbItems++;
                    }

                    if (page != 0) inv.setItem(48, getFromValue(PREVIOUS));
                    if (nbItems == 36) inv.setItem(50, getFromValue(NEXT));

                    new BukkitRunnable()
                    {
                        @Override
                        public void run()
                        {
                            player.openInventory(inv);
                        }
                    }.runTask(Main.getPlugin());
                } catch (SQLException e)
                {
                    e.printStackTrace();
                }
            }
        }.runTaskAsynchronously(Main.getPlugin());
    }

    public static void openItem(ItemStack itemStack, Player player)
    {
        Inventory inv = Bukkit.createInventory(null, 54, "Hotel des ventes");

        inv.setItem(22, itemStack);


        ItemStack cancel = new ItemStack(Material.BARRIER);
        ItemMeta cancelMeta = cancel.getItemMeta();
        cancelMeta.setDisplayName("§rAnnuler");
        cancel.setItemMeta(cancelMeta);

        inv.setItem(29, cancel);

        inv.setItem(31, itemStack);
        inv.setItem(32, itemStack);
        inv.setItem(33, itemStack);


        player.openInventory(inv);
    }
}
