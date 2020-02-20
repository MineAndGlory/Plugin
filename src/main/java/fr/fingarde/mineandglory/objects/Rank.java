package fr.fingarde.mineandglory.objects;


import fr.fingarde.mineandglory.utils.Config;
import org.bukkit.configuration.MemorySection;
import org.bukkit.configuration.file.YamlConfiguration;

import java.util.ArrayList;

public class Rank {
    private static ArrayList<Rank> ranks = new ArrayList<>();

    private String name;
    private String prefix;
    private String suffix;

    private String teamName;

    private ArrayList<String> inherits;
    private ArrayList<String> permissions = new ArrayList<>();

    private String chatColor;

    private boolean isDefault = false;

    public Rank(String rank)
    {
        YamlConfiguration config = Config.getRankConfig();

        if(!config.contains(rank.toLowerCase())) { return; }

        this.name = rank;
        name = rank;

        MemorySection data = (MemorySection) config.getConfigurationSection(rank);

        prefix = data.getString("prefix");
        suffix = data.getString("suffix");

        teamName = "99_" + rank;
        if(data.contains("place_in_tab")) teamName = data.getString("place_in_tab") + "_" + rank;

        if(data.contains("permissions")) permissions = (ArrayList<String>) data.get("permissions");
        if(data.contains("inherit"))
        {
            inherits = (ArrayList<String>) data.get("inherit");

            for(String inherit : inherits)
            {
                Rank inheritRank = getByName(inherit);
                if(inheritRank == null) inheritRank = new Rank(inherit);

                permissions.addAll(inheritRank.getPermissions());
            }
        }



        if(data.contains("chat_color")) chatColor = data.getString("chat_color");
        if(data.contains("default")) isDefault = data.getBoolean("default");

        ranks.add(this);
    }

    // Getters And Setters

    public String getName() {
        return name;
    }

    public ArrayList<String> getPermissions() {
        return permissions;
    }

    public String getPrefix() {
        return prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public String getTeamName() {
        return teamName;
    }

    public String getChatColor() {
        return chatColor;
    }

    // Functions

    public static void loadRanks() {
        YamlConfiguration config = Config.getRankConfig();

        for(String key : config.getKeys(false)) {
            new Rank(key);
        }

    }
    public static Rank getByName(String name) {
        for(Rank rank : ranks) {
            if(rank.name.equalsIgnoreCase(name)) {
                return rank;
            }
        }

        return null;
    }

    public static Rank getDefaultRank() {
        for(Rank rank : ranks) {
            if(rank.isDefault) {
                return rank;
            }
        }

        return null;
    }
}