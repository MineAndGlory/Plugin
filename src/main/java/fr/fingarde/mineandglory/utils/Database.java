package fr.fingarde.mineandglory.utils;

import com.zaxxer.hikari.HikariDataSource;
import fr.fingarde.mineandglory.Main;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
    private static HikariDataSource source;

    public static void connectDB() {
        YamlConfiguration config = Config.getDatabaseConfig();

        source = new HikariDataSource();
        source.setDataSourceClassName("com.mysql.jdbc.jdbc2.optional.MysqlDataSource");

        source.addDataSourceProperty("serverName", config.getString("host"));
        source.addDataSourceProperty("port", config.getInt("port"));
        source.addDataSourceProperty("databaseName", config.getString("database"));
        source.addDataSourceProperty("user", config.getString("user"));
        source.addDataSourceProperty("password", config.getString("password"));

        source.addDataSourceProperty("allowPublicKeyRetrieval",true);
        source.addDataSourceProperty("verifyServerCertificate", false);
        source.addDataSourceProperty("useSSL", false);

        source.addDataSourceProperty("tcpKeepAlive", true);
        source.addDataSourceProperty("autoReconnect", true);
        source.addDataSourceProperty("connectTimeout", 300);

        source.addDataSourceProperty("characterEncoding","utf8");
        source.addDataSourceProperty("useUnicode","true");
    }

    public static void createTables() {
        try {
            Connection connection = source.getConnection();
            Statement statement = connection.createStatement();

            statement.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS tb_player(" +
                            "uuid VARCHAR(36) NOT NULL PRIMARY KEY," +
                            "player_rank VARCHAR(36)," +
                            "money NUMERIC(15,2)," +
                            "glory NUMERIC(10)," +
                            "xp NUMERIC(10)," +
                            "nick VARCHAR(64)," +
                            "prefix VARCHAR(64)," +
                            "suffix VARCHAR(64)," +
                            "first_join NUMERIC(16)" +
                            ");");

            statement.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS tb_ender_chest(" +
                            "player VARCHAR(36) NOT NULL PRIMARY KEY," +
                            "size NUMERIC(2)," +
                            "item TEXT" +
                            ");");

            statement.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS death(" +
                            "id INT NOT NULL PRIMARY KEY AUTO_INCREMENT," +
                            "player VARCHAR(36)," +
                            "location VARCHAR(64)," +
                            "gravestone_location VARCHAR(64)," +
                            "reason VARCHAR(64)," +
                            "date  NUMERIC(16)," +
                            "collected BOOL," +
                            "money  NUMERIC(15,2)," +
                            "xp  NUMERIC(10)," +
                            "item TEXT" +
                            ");");



            /* NOT USED
            statement.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS warn(" +
                            "player VARCHAR(36) NOT NULL," +
                            "moderator VARCHAR(36)," +
                            "type VARCHAR(32)," +
                            "reason TEXT," +
                            "date NUMERIC(16) NOT NULL ," +
                            "time NUMERIC(16)," +
                            "PRIMARY KEY (player, date)" +
                        ");");



            statement.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS waystone(" +
                            "id INT NOT NULL PRIMARY KEY," +
                            "owner VARCHAR(36)," +
                            "name VARCHAR(32)," +
                            "location VARCHAR(64) NOT NULL," +
                            "exit_location VARCHAR(64)," +
                            "date  NUMERIC(16)" +
                        ");");
            statement.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS waystone_member(" +
                            "id INT NOT NULL," +
                            "player VARCHAR(36)," +
                            "PRIMARY KEY (id, player)" +
                        ");");

            statement.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS event(" +
                            "id INT NOT NULL PRIMARY KEY," +
                            "location VARCHAR(64)," +
                            "type VARCHAR(32)," +
                            "date  NUMERIC(16)" +
                        ");");

            statement.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS event_winner(" +
                            "id INT NOT NULL," +
                            "player VARCHAR(36)," +
                            "reward TEXT," +
                            "PRIMARY KEY (id, player)" +
                        ");");

            statement.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS death(" +
                            "id INT NOT NULL PRIMARY KEY," +
                            "player VARCHAR(36)," +
                            "location VARCHAR(64)," +
                            "reason VARCHAR(64)," +
                            "date  NUMERIC(16)" +
                        ");");

            statement.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS death_gravestone(" +
                            "id INT NOT NULL PRIMARY KEY," +
                            "location VARCHAR(64)," +
                            "collected BOOL," +
                            "money  NUMERIC(15,2)," +
                            "xp  NUMERIC(10)," +
                            "item TEXT" +
                        ");");

            statement.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS backpack(" +
                            "id INT NOT NULL PRIMARY KEY," +
                            "item TEXT" +
                        ");");

            statement.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS job(" +
                            "player VARCHAR(36) NOT NULL PRIMARY KEY," +
                            "farmer_lvl NUMERIC(3)," +
                            "farmer_exp NUMERIC(7)," +
                            "animal_breeder_lvl NUMERIC(3)," +
                            "animal_breeder_exp NUMERIC(7)," +
                            "miner_lvl NUMERIC(3)," +
                            "miner_exp NUMERIC(7)," +
                            "woodcutter_lvl NUMERIC(3)," +
                            "woodcutter_exp NUMERIC(7)," +
                            "armorer_lvl NUMERIC(3)," +
                            "armorer_exp NUMERIC(7)," +
                            "fisher_lvl NUMERIC(3)," +
                            "fisher_exp NUMERIC(7)," +
                            "hunter_lvl NUMERIC(3)," +
                            "hunter_exp NUMERIC(7)," +
                            "cooker_lvl NUMERIC(3)," +
                            "cooker_exp NUMERIC(7)," +
                            "builder_lvl NUMERIC(3)," +
                            "builder_exp NUMERIC(7)," +
                            "terraformer_lvl NUMERIC(3)," +
                            "terraformer_exp NUMERIC(7)," +
                            "blacksmith_lvl NUMERIC(3)," +
                            "blacksmith_exp NUMERIC(7)," +
                            "enchanter_lvl NUMERIC(3)," +
                            "enchanter_exp NUMERIC(7)," +
                            "alchemist_lvl NUMERIC(3)," +
                            "alchemist_exp NUMERIC(7)," +
                            "barman_lvl NUMERIC(3)," +
                            "barman_exp NUMERIC(7)" +
                        ");");

            statement.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS market(" +
                            "id INT NOT NULL PRIMARY KEY," +
                            "seller VARCHAR(36)," +
                            "buyer VARCHAR(36)," +
                            "price NUMERIC(15,2)," +
                            "date  NUMERIC(16) NOT NULL," +
                            "buyed_date NUMERIC(16)," +
                            "collected BOOL" +
                        ");");

            statement.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS trade(" +
                            "id INT NOT NULL PRIMARY KEY," +
                            "player1 VARCHAR(36) NOT NULL," +
                            "player2 VARCHAR(36) NOT NULL ," +
                            "money_player1 NUMERIC(15,2)," +
                            "money_player2 NUMERIC(15,2)," +
                            "item_player1 TEXT," +
                            "item_player2 TEXT," +
                            "date NUMERIC(16) NOT NULL" +
                        ");");

            statement.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS market_price(" +
                            "id INT NOT NULL PRIMARY KEY," +
                            "old_market_price INT," +
                            "item VARCHAR(64) NOT NULL," +
                            "amount_selled NUMERIC(7)," +
                            "amount_buyed NUMERIC(7)," +
                            "new_price NUMERIC(15,2) NOT NULL," +
                            "date  NUMERIC(16) NOT NULL" +
                        ");");*/

            statement.close();
            connection.close();
        }
        catch(SQLException e) {
            e.printStackTrace();
            Bukkit.getPluginManager().disablePlugin(Main.getPlugin());
        }
    }

    public static HikariDataSource getSource() {
        return source;
    }
}
