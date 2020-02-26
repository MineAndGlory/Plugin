package fr.fingarde.mineandglory.utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Title {
    public static void sendActionbar(Player player, String message) {
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "title " + player.getName() + " actionbar {\"text\":\"" + message + "\"}");
    }
}
