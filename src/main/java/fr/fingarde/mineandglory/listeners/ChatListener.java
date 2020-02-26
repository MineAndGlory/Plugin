package fr.fingarde.mineandglory.listeners;

import fr.fingarde.mineandglory.objects.User;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements Listener {
    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();

        event.setCancelled(true);

        User user = User.getByUUID(player.getUniqueId());

        String message = event.getMessage().replaceAll("&", "§");

        message = ((user.getRank().getChatColor() == null) ? "§r" : user.getRank().getChatColor()) + message;

        if(player.hasPermission("chat.mention.user")) {
            for (Player players : Bukkit.getOnlinePlayers()) {
                if (message.toLowerCase().contains(players.getName().toLowerCase())) {
                    String color = ChatColor.getLastColors(message.substring(0, message.toLowerCase().lastIndexOf(players.getName().toLowerCase())));
                    int start = message.toLowerCase().indexOf(players.getName().toLowerCase());

                    message = message.replaceAll(message.substring(start, start + players.getName().length()), "§a" + players.getName() + color);

                    players.playSound(players.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 0.5f, 2);
                }
            }
        }

        Bukkit.broadcastMessage(player.getDisplayName() + " §r§6❭❭ " + message);
    }
}
