package fr.fingarde.mineandglory.listeners;

import fr.fingarde.mineandglory.objects.User;
import fr.fingarde.mineandglory.utils.ColorUtils;
import fr.fingarde.mineandglory.utils.TitleUtils;
import org.apache.commons.lang.CharUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.Arrays;
import java.util.List;

public class ChatListener implements Listener
{
    @EventHandler
    public void onChat(AsyncPlayerChatEvent event)
    {

        event.setCancelled(true);

        Player player = event.getPlayer();
        User user = User.getByUUID(player.getUniqueId());

        String message = ColorUtils.encodeAmperstamp(event.getMessage());
        message = ((user.getRank().getChatColor() == null) ? "§r" : user.getRank().getChatColor()) + message;

        if (player.hasPermission("chat.mention.user"))
        {
            for (Player players : Bukkit.getOnlinePlayers())
            {
                if (message.toLowerCase().contains(players.getName().toLowerCase()))
                {
                    TitleUtils.sendActionbar(players, player.getDisplayName() + " &avous a mentionné");

                    String color = ChatColor.getLastColors(message.substring(0, message.toLowerCase().lastIndexOf(players.getName().toLowerCase())));
                    int start = message.toLowerCase().indexOf(players.getName().toLowerCase());

                    message = message.replaceAll(message.substring(start, start + players.getName().length()), "§a" + players.getName() + color);

                    players.playSound(players.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 0.5f, 2);
                }
            }
        }

        List<String> lines = Arrays.asList(message.split("\\n"));
        Bukkit.broadcastMessage(player.getDisplayName() + " §r§6❭❭ " + lines.get(0));
        lines.remove(0);

        for(String line : lines) {
            Bukkit.broadcastMessage(line);
        }
    }
}
