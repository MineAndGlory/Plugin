package fr.fingarde.mineandglory.listeners;

import fr.fingarde.mineandglory.Main;
import fr.fingarde.mineandglory.objects.Rank;
import fr.fingarde.mineandglory.objects.User;
import fr.fingarde.mineandglory.objects.items.CustomItems;
import fr.fingarde.mineandglory.recipes.ShapelessCraft;
import fr.fingarde.mineandglory.utils.storage.Database;
import fr.fingarde.mineandglory.utils.TitleUtils;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.CraftingInventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class ConnectionListener implements Listener
{
    @EventHandler
    public void onJoin(PlayerJoinEvent event)
    {
        event.setJoinMessage(null);


        Player player = event.getPlayer();

        new BukkitRunnable()
        {
            @Override
            public void run()
            {
                try (
                        Connection connection = Database.getSource().getConnection();
                        Statement statement = connection.createStatement();

                        ResultSet result = statement.executeQuery("SELECT * FROM tb_player WHERE pl_uuid = '" + player.getUniqueId().toString() + "'"))
                {

                    Rank defaultRank = Rank.getDefaultRank();
                    if (defaultRank == null)
                    {
                        Main.getConsole().sendMessage("Aucun rank par défaut n'a été défini");
                        return;
                    }

                    if (!result.next())
                    {
                        statement.executeUpdate("INSERT INTO tb_player (pl_uuid, pl_rank, pl_first_join) VALUES ('" + player.getUniqueId().toString() + "', '" + defaultRank.getName() + "', '" + new Date().getTime() + "')");
                        statement.executeUpdate("INSERT INTO tb_enderchest (ec_player, ec_size) VALUES ('" + player.getUniqueId().toString() + "', '5')");
                        statement.executeUpdate("INSERT INTO tb_job (jb_player) VALUES ('" + player.getUniqueId().toString() + "')");

                        Bukkit.broadcastMessage(player.getDisplayName() + " §evient de rejoindre le serveur pour la première fois!");
                        statement.close();
                        connection.close();
                    }

                    User user = new User(event.getPlayer().getUniqueId());
                    User.users.add(user);

                    user.loadName();
                    user.loadPermissions();

                    Bukkit.broadcastMessage("§a§l+§r " + player.getDisplayName());

                    result.close();
                    statement.close();
                    connection.close();
                } catch (SQLException e)
                {
                    e.printStackTrace();
                }
            }
        }.runTaskAsynchronously(Main.getPlugin());

        new BukkitRunnable()
        {
            @Override
            public void run()
            {
                Location loc = player.getLocation();
                loc.setY(loc.getY() + 1.8);

                player.spawnParticle(Particle.TOTEM, loc, 150, 0, 0, 0, 0.4);
                TitleUtils.sendTitle(player, "§cMine And Glory");
            }
        }.runTaskLater(Main.getPlugin(), 5);
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event)
    {
        event.setQuitMessage(null);

        User user = User.getByUUID(event.getPlayer().getUniqueId());
        User.users.remove(user);

        Bukkit.broadcastMessage("§c§l-§r " + event.getPlayer().getDisplayName());
    }

    public static class CraftListener implements Listener
    {
        public static List<ShapelessCraft> shapelessCrafts = new LinkedList<>();

        @EventHandler
        public void onPrepareCraft(PrepareItemCraftEvent event)
        {
            for (ShapelessCraft craft : shapelessCrafts)
            {
                if (craft.equals(event.getInventory().getMatrix()))
                {
                    event.getInventory().setResult(craft.getResult());
                    return;
                }
            }
        }

        @EventHandler
        public void onCraft(final InventoryClickEvent event)
        {
            if (event.getClickedInventory() == null) return;
            if (event.getClickedInventory().getType() != InventoryType.WORKBENCH) return;

            CraftingInventory inv = (CraftingInventory) event.getClickedInventory();

            if (event.getSlotType() != InventoryType.SlotType.RESULT) return;
            if (inv.getResult() == null) return;
            if (inv.getRecipe() != null) return;

            if (event.getCursor().getMaxStackSize() == 1) return;

            if (event.getClick().name().startsWith("SHIFT"))
            {
                event.setCancelled(true);
                return;
            }

            new BukkitRunnable()
            {
                @Override
                public void run()
                {
                    for (ItemStack item : inv.getMatrix())
                    {
                        if (item == null) continue;

                        item.setAmount(item.getAmount() / 2);
                    }
                }
            }.runTaskLater(Main.getPlugin(), 0);
        }
    }
}
