package fr.fingarde.mineandglory.objects;


import fr.fingarde.mineandglory.Main;
import fr.fingarde.mineandglory.utils.storage.Database;
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

public class User
{
    public static ArrayList<User> users = new ArrayList<>();

    private UUID uuid;

    private Rank rank;
    private Job jobs;

    private float money;
    private int glory;
    private int xp;

    private String nickname;
    private String prefix;
    private String suffix;

    private OfflinePlayer player;

    public User(UUID uuid)
    {
        this.uuid = uuid;

        try (Connection connection = Database.getSource().getConnection();
             Statement statement = connection.createStatement();

             ResultSet result = statement.executeQuery("SELECT pl_uuid, pl_rank, pl_prefix, pl_suffix, pl_nick, pl_money, pl_glory, tb_job.* " +
                     "FROM tb_player, tb_job " +
                     "WHERE jb_player = pl_uuid " +
                     "AND pl_uuid = '" + uuid.toString() + "'"))
        {

            if (!result.next()) return;

            rank = new Rank(result.getString("pl_rank"));
            jobs = new Job();

            prefix = result.getString("pl_prefix");
            suffix = result.getString("pl_suffix");
            nickname = result.getString("pl_nick");

            money = result.getFloat("pl_money");
            glory = result.getInt("pl_glory");

            jobs.setFarmerLvl(result.getInt("jb_farmer_lvl"));
            jobs.setFarmerExp(result.getInt("jb_farmer_lvl"));

            jobs.setAnimalBreaderLvl(result.getInt("jb_animal_breeder_lvl"));
            jobs.setAnimalBreaderExp(result.getInt("jb_animal_breeder_exp"));

            jobs.setMinerLvl(result.getInt("jb_miner_lvl"));
            jobs.setMinerExp(result.getInt("jb_miner_exp"));

            jobs.setWoodcutterLvl(result.getInt("jb_woodcutter_lvl"));
            jobs.setWoodcutterExp(result.getInt("jb_woodcutter_exp"));

            jobs.setArmorerLvl(result.getInt("jb_armorer_lvl"));
            jobs.setArmorerExp(result.getInt("jb_armorer_exp"));

            jobs.setFisherLvl(result.getInt("jb_fisher_lvl"));
            jobs.setFisherExp(result.getInt("jb_fisher_exp"));

            jobs.setHunterLvl(result.getInt("jb_hunter_lvl"));
            jobs.setHunterExp(result.getInt("jb_hunter_exp"));

            jobs.setCookerLvl(result.getInt("jb_cooker_lvl"));
            jobs.setCookerExp(result.getInt("jb_cooker_exp"));

            jobs.setBuilderLvl(result.getInt("jb_builder_lvl"));
            jobs.setBuilderExp(result.getInt("jb_builder_exp"));

            jobs.setTerraformerLvl(result.getInt("jb_terraformer_lvl"));
            jobs.setTerraformerExp(result.getInt("jb_terraformer_exp"));

            jobs.setBlacksmithLvl(result.getInt("jb_blacksmith_lvl"));
            jobs.setBlacksmithExp(result.getInt("jb_blacksmith_exp"));

            jobs.setEnchanterLvl(result.getInt("jb_enchanter_lvl"));
            jobs.setEnchanterExp(result.getInt("jb_enchanter_lvl"));

            jobs.setAlchemistLvl(result.getInt("jb_alchemist_lvl"));
            jobs.setAlchemistExp(result.getInt("jb_alchemist_exp"));

            player = Bukkit.getOfflinePlayer(uuid);

            result.close();
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    // Getters and setters

    public Rank getRank()
    {
        return rank;
    }

    public String getNickname()
    {
        return nickname;
    }

    public String getPrefix()
    {
        return prefix;
    }

    public String getSuffix()
    {
        return suffix;
    }

    public OfflinePlayer getPlayer()
    {
        return player;
    }

    public UUID getUUID()
    {
        return uuid;
    }

    public Job getJobs()
    {
        return jobs;
    }

    public float getMoney()
    {
        return money;
    }

    // Functions

    public void loadName()
    {
        String nameNickname = player.getName();
        String namePrefix = "", nameSuffix = "";

        if (rank.getPrefix() != null) namePrefix = rank.getPrefix();
        if (rank.getSuffix() != null) nameSuffix = rank.getSuffix();

        if (prefix != null) namePrefix = prefix;
        if (suffix != null) nameSuffix = suffix;

        if (nickname != null) nameNickname = nickname;

        if (namePrefix != "") namePrefix = namePrefix + " ";
        if (nameSuffix != "") nameSuffix = " " + nameSuffix;

        ((Player) player).setDisplayName(namePrefix + nameNickname + nameSuffix);
        ((Player) player).setPlayerListName(((Player) player).getDisplayName());

        try
        {
            Bukkit.getScoreboardManager().getMainScoreboard().registerNewTeam(rank.getTeamName());
        } catch (IllegalArgumentException e)
        {
        }

        Team team = Bukkit.getScoreboardManager().getMainScoreboard().getTeam(rank.getTeamName());
        team.addEntry(((Player) player).getName());
    }

    public void loadPermissions()
    {
        if (rank.getPermissions() != null)
        {
            PermissionAttachment attachment = ((Player) player).addAttachment(Main.getPlugin());

            for (String permission : rank.getPermissions())
            {
                if (permission.startsWith("-"))
                {
                    permission = permission.substring(1);
                    attachment.setPermission(permission, false);
                } else
                {
                    attachment.setPermission(permission, true);
                }
            }
        }
    }

    public static User getByUUID(UUID uuid)
    {
        for (User user : users)
        {
            if (user.uuid == uuid) return user;
        }

        return null;
    }
}
