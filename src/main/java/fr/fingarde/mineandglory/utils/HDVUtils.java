package fr.fingarde.mineandglory.utils;

import fr.fingarde.mineandglory.Main;
import fr.fingarde.mineandglory.utils.serializer.ItemSerializer;
import fr.fingarde.mineandglory.utils.storage.Database;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.scheduler.BukkitRunnable;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static fr.fingarde.mineandglory.objects.items.CustomItems.*;

public class HDVUtils
{
    public static void openPage(int page, Player player)
    {
        Inventory inv = Bukkit.createInventory(null, 54, "Hotel des ventes");

        new BukkitRunnable()
        {
            @Override
            public void run()
            {
                try (
                        Connection connection = Database.getSource().getConnection();
                        Statement statement = connection.createStatement();

                        ResultSet result = statement.executeQuery("SELECT * FROM tb_market ORDER BY mk_date DESC LIMIT " + (page * 36) + ", " + ((page + 1) * 36)))
                {
                    int nbItems = 0;
                    while (result.next())
                    {
                        nbItems++;
                        inv.setItem(nbItems, ItemSerializer.deserializeItem(result.getString("mk_item")));
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
}
