package fr.fingarde.mineandglory.utils.serializer;

import org.bukkit.inventory.ItemStack;
import org.bukkit.util.io.BukkitObjectInputStream;
import org.bukkit.util.io.BukkitObjectOutputStream;
import org.yaml.snakeyaml.external.biz.base64Coder.Base64Coder;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ItemSerializer
{
    public static String serializeArray(ItemStack[] items)
    {
        try
        {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            BukkitObjectOutputStream dataOutput;
            dataOutput = new BukkitObjectOutputStream(outputStream);

            dataOutput.writeInt(items.length);

            for (int i = 0; i < items.length; i++)
            {
                dataOutput.writeObject(items[i]);
            }

            dataOutput.close();

            return Base64Coder.encodeLines(outputStream.toByteArray());
        } catch (Exception e)
        {
            throw new IllegalStateException("Unable to save item stacks.", e);
        }
    }

    public static String serializeItem(ItemStack item)
    {
        try
        {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            BukkitObjectOutputStream dataOutput;
            dataOutput = new BukkitObjectOutputStream(outputStream);

            dataOutput.writeObject(item);

            dataOutput.close();

            return Base64Coder.encodeLines(outputStream.toByteArray());
        } catch (Exception e)
        {
            throw new IllegalStateException("Unable to save item stack.", e);
        }
    }

    public static ItemStack[] deserializeArray(String data)
    {
        try
        {
            ByteArrayInputStream inputStream = new ByteArrayInputStream(Base64Coder.decodeLines(data));
            BukkitObjectInputStream dataInput = new BukkitObjectInputStream(inputStream);
            ItemStack[] items = new ItemStack[dataInput.readInt()];

            for (int i = 0; i < items.length; i++)
            {
                items[i] = (ItemStack) dataInput.readObject();
            }

            dataInput.close();

            return items;
        } catch (ClassNotFoundException | IOException e)
        {
            e.printStackTrace();
        }

        return null;
    }

    public static ItemStack deserializeItem(String data)
    {
        try
        {
            ByteArrayInputStream inputStream = new ByteArrayInputStream(Base64Coder.decodeLines(data));
            BukkitObjectInputStream dataInput = new BukkitObjectInputStream(inputStream);
            ItemStack item = (ItemStack) dataInput.readObject();

            dataInput.close();

            return item;
        } catch (ClassNotFoundException | IOException e)
        {
            e.printStackTrace();
        }

        return null;
    }
}
