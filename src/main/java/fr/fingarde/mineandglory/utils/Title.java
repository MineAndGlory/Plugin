package fr.fingarde.mineandglory.utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Title
{
    public static void sendActionbar(Player player, String message)
    {
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "title " + player.getName() + " actionbar {\"text\":\"" + message + "\"}");
    }

    public static void sendTitle(Player player, String message)
    {
        sendTitle(player, message, 40);
    }

    public static void sendTitle(Player player, String message, int duration)
    {
        sendTitle(player, message, 5, duration, 5);
    }

    public static void sendTitle(Player player, String message, int fadeIn, int duration, int fadeOut)
    {
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "title " + player.getName() + " times " + fadeIn + " " + duration + " " + fadeOut);
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "title " + player.getName() + " title {\"text\":\"" + message + "\"}");
    }

    public static void sendSubtitle(Player player, String message)
    {
        sendSubtitle(player, message, 40);
    }

    public static void sendSubtitle(Player player, String message, int duration)
    {
        sendSubtitle(player, message, 5, duration, 5);
    }

    public static void sendSubtitle(Player player, String message, int fadeIn, int duration, int fadeOut)
    {
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "title " + player.getName() + " times " + fadeIn + " " + duration + " " + fadeOut);
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "title " + player.getName() + " subtitle {\"text\":\"" + message + "\"}");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "title " + player.getName() + " subtitle {\"text\":\" \"}");
    }
}
