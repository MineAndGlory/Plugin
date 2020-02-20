package fr.fingarde.mineandglory.utils;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.MemorySection;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Config {
    private static String folder = "MineAndGlory";

    public static YamlConfiguration getDatabaseConfig() {
        try {
            YamlConfiguration config = new YamlConfiguration();

            File configFile = new File("plugins/" + folder + "/", "database.yml");
            if(!configFile.exists()) createDatabaseConfig();

            config.load(configFile);

            return config;
        }
        catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidConfigurationException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static YamlConfiguration getRankConfig() {
        try {
            YamlConfiguration config = new YamlConfiguration();

            File configFile = new File("plugins/" + folder + "/", "rank.yml");
            if(!configFile.exists()) createRankConfig();

            config.load(configFile);

            return config;
        }
        catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidConfigurationException e) {
            e.printStackTrace();
        }

        return null;
    }


    private static void createConfigFolder() {
        File file = new File("plugins/" + folder);

        if(!file.exists()) file.mkdirs();
    }

    private static void createDatabaseConfig() {
        try {
            YamlConfiguration config = new YamlConfiguration();

            File configFile = new File("plugins/" + folder + "/", "database.yml");

            createConfigFolder();
            configFile.createNewFile();

            config.set("host", "localhost");
            config.set("port", "port");
            config.set("database", "database");
            config.set("user", "root");
            config.set("password", "root");

            config.save(configFile);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void createRankConfig() {
        try {
            YamlConfiguration config = new YamlConfiguration();

            File configFile = new File("plugins/" + folder + "/", "rank.yml");

            createConfigFolder();
            configFile.createNewFile();

            /// -------------
            MemorySection visitor = (MemorySection) config.createSection("visitor");

            visitor.set("default", true);

            ArrayList<String> permisionsVisitor = new ArrayList<>();
            permisionsVisitor.add("chat.send");

            visitor.set("permissions", permisionsVisitor);

            /// -------------
            MemorySection member = (MemorySection) config.createSection("member");

            member.set("prefix", "§7Member");

            ArrayList<String> inherit = new ArrayList<>();
            inherit.add("visitor");

            member.set("inherit", inherit);


            ArrayList<String> permisionsMember = new ArrayList<>();
            permisionsMember.add("chat.mention.user");
            permisionsMember.add("world.interact");

            member.set("permissions", permisionsMember);

            /// -------------
            MemorySection owner = (MemorySection) config.createSection("owner");

            owner.set("prefix", "§c§lOwner");
            owner.set("chat_color", "§c");
            owner.set("place_in_tab", "1");

            config.save(configFile);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
