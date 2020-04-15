package fr.fingarde.mineandglory.commands;

import fr.fingarde.mineandglory.utils.ErrorMessage;
import fr.fingarde.mineandglory.utils.serializer.ItemSerializer;
import fr.fingarde.mineandglory.utils.storage.Database;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EnderChestCommand implements CommandExecutor
{
    private String permission = "command.enderchest";

    @Override
    public boolean onCommand(CommandSender sender, Command command, String alias, String[] arguments)
    {
        if(!(sender instanceof Player)) {
            sender.sendMessage(ErrorMessage.onlyPlayer());
            return false;
        }

        Player player = (Player) sender;
        if(!player.hasPermission(permission)) {
            player.sendMessage(ErrorMessage.noPermissionMessage(permission));
            return false;
        }

        try (Connection connection = Database.getSource().getConnection();
             Statement statement = connection.createStatement();
             ResultSet result = statement.executeQuery("SELECT * FROM tb_enderchest WHERE ec_player = '" + player.getPlayer().getUniqueId().toString() + "'"))
        {
            result.next();

            Inventory inv = Bukkit.createInventory(null, 36, "Enderchest");

            if (result.getString("ec_items") != null)
            {
                inv.setContents(ItemSerializer.deserializeArray(result.getString("ec_items")));
            }

            for (int i = result.getInt("ec_size"); i < 36; i++)
            {
                inv.setItem(i, new ItemStack(Material.BARRIER));
            }

            player.openInventory(inv);
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        return false;
    }
}
