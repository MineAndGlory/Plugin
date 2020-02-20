package fr.fingarde.mineandglory.objects;


import fr.fingarde.mineandglory.Main;
import fr.fingarde.mineandglory.utils.Database;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.scoreboard.Team;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.UUID;

public class User {
    public static ArrayList<User> users = new ArrayList<>();

    private UUID uuid;

    private Rank rank;

    private float money;
    private int glory;
    private int xp;

    private String nickname;
    private String prefix;
    private String suffix;

    private long firstJoin;

    private OfflinePlayer player;

    public User(UUID uuid) {
        this.uuid = uuid;

        try {
            Connection connection = Database.getSource().getConnection();
            Statement statement = connection.createStatement();

            ResultSet result = statement.executeQuery("SELECT * FROM player WHERE uuid = '" + uuid.toString() + "'");

            if(!result.next()) return;

            rank = new Rank(result.getString("player_rank"));

            money = result.getFloat("money");
            glory = result.getInt("glory");
            xp = result.getInt("xp");

            firstJoin = result.getLong("first_join");

            player = Bukkit.getOfflinePlayer(uuid);

            result.close();
            statement.close();
            connection.close();

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Getters and setters

    public Rank getRank() {
        return rank;
    }

    public String getNickname() {
        return nickname;
    }

    public String getPrefix() {
        return prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public OfflinePlayer getPlayer() {
        return player;
    }

    public UUID getUUID() {
        return uuid;
    }

    // Functions

    public void loadName() {
        String nameNickname = player.getName();
        String namePrefix = "", nameSuffix = "";

        if(rank.getPrefix() != null) namePrefix = rank.getPrefix();
        if(rank.getSuffix() != null) nameSuffix = rank.getSuffix();

        if(prefix != null) namePrefix = prefix;
        if(suffix != null) nameSuffix = suffix;

        if(nickname != null) nameNickname = nickname;

        if(namePrefix != "") namePrefix = namePrefix + " ";
        if(nameSuffix != "") nameSuffix = " " + nameSuffix;

        ((Player) player).setDisplayName(namePrefix + nameNickname + nameSuffix);
        ((Player) player).setPlayerListName(((Player) player).getDisplayName());

        try
        {
            Bukkit.getScoreboardManager().getMainScoreboard().registerNewTeam(rank.getTeamName());
        }
        catch (IllegalArgumentException e) { }

        Team team = Bukkit.getScoreboardManager().getMainScoreboard().getTeam(rank.getTeamName());
        team.addEntry(((Player) player).getName());
    }

    public void loadPermissions() {
        if (rank.getPermissions() != null) {
            PermissionAttachment attachment = ((Player) player).addAttachment(Main.getPlugin());

            for (String permission : rank.getPermissions()) {
                if (permission.startsWith("-")) {
                    permission = permission.substring(1);
                    attachment.setPermission(permission, false);
                } else {
                    attachment.setPermission(permission, true);
                }
            }
        }
    }

    public static User getByUUID(UUID uuid) {
        for(User user : users) {
            if(user.uuid == uuid) return user;
        }

        return null;
    }
}
