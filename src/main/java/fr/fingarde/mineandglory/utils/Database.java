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
                    "pl_uuid VARCHAR(36) PRIMARY KEY," +
                    "pl_rank VARCHAR(36)," +
                    "pl_prefix VARCHAR(64)," +
                    "pl_suffix VARCHAR(64)," +
                    "pl_nick VARCHAR(64)," +
                    "pl_first_join NUMERIC(16)," +
                    "pl_money NUMERIC(15,2) DEFAULT 0," +
                    "pl_glory NUMERIC(10) DEFAULT 0" +
                ");");

            statement.executeUpdate(
            "CREATE TABLE IF NOT EXISTS tb_enderchest(" +
                    "ec_player VARCHAR(36) PRIMARY KEY," +
                    "ec_size NUMERIC(2) DEFAULT 0," +
                    "ec_items TEXT," +
                    "CONSTRAINT fk_tb_enderchest FOREIGN KEY(ec_player) REFERENCES tb_player(pl_uuid)" +
                ");");

            statement.executeUpdate(
            "CREATE TABLE IF NOT EXISTS tb_death(" +
                    "dh_uuid VARCHAR(36) PRIMARY KEY," +
                    "dh_player VARCHAR(36)," +
                    "dh_location VARCHAR(64)," +
                    "dh_reason VARCHAR(64)," +
                    "dh_date DATE," +
                    "CONSTRAINT fk_tb_death FOREIGN KEY(dh_player) REFERENCES tb_player(pl_uuid)" +
                ");");

            statement.executeUpdate(
            "CREATE TABLE IF NOT EXISTS tb_gravestone(" +
                    "gs_death VARCHAR(36) PRIMARY KEY," +
                    "gs_location VARCHAR(64)," +
                    "gs_collected BOOL DEFAULT FALSE," +
                    "gs_money NUMERIC(15,2) DEFAULT 0," +
                    "gs_xp NUMERIC(10) DEFAULT 0," +
                    "gs_items TEXT," +
                    "CONSTRAINT fk_tb_gravestone FOREIGN KEY(gs_death) REFERENCES tb_death(dh_uuid)" +
                ");");

            statement.executeUpdate(
            "CREATE TABLE IF NOT EXISTS tb_job(" +
                    "jb_player VARCHAR(36) PRIMARY KEY," +

                    "jb_farmer_lvl NUMERIC(3) DEFAULT 1," +
                    "jb_farmer_exp NUMERIC(7) DEFAULT 0," +

                    "jb_animal_breeder_lvl NUMERIC(3) DEFAULT 1," +
                    "jb_animal_breeder_exp NUMERIC(7) DEFAULT 0," +

                    "jb_miner_lvl NUMERIC(3) DEFAULT 1," +
                    "jb_miner_exp NUMERIC(7) DEFAULT 0," +

                    "jb_woodcutter_lvl NUMERIC(3) DEFAULT 1," +
                    "jb_woodcutter_exp NUMERIC(7) DEFAULT 0," +

                    "jb_armorer_lvl NUMERIC(3) DEFAULT 1," +
                    "jb_armorer_exp NUMERIC(7) DEFAULT 0," +

                    "jb_fisher_lvl NUMERIC(3) DEFAULT 1," +
                    "jb_fisher_exp NUMERIC(7) DEFAULT 0," +

                    "jb_hunter_lvl NUMERIC(3) DEFAULT 1," +
                    "jb_hunter_exp NUMERIC(7) DEFAULT 0," +

                    "jb_cooker_lvl NUMERIC(3) DEFAULT 1," +
                    "jb_cooker_exp NUMERIC(7) DEFAULT 0," +

                    "jb_builder_lvl NUMERIC(3) DEFAULT 1," +
                    "jb_builder_exp NUMERIC(7) DEFAULT 0," +

                    "jb_terraformer_lvl NUMERIC(3) DEFAULT 1," +
                    "jb_terraformer_exp NUMERIC(7) DEFAULT 0," +

                    "jb_blacksmith_lvl NUMERIC(3) DEFAULT 1," +
                    "jb_blacksmith_exp NUMERIC(7) DEFAULT 0," +

                    "jb_enchanter_lvl NUMERIC(3) DEFAULT 1," +
                    "jb_enchanter_lvl NUMERIC(7) DEFAULT 0," +

                    "jb_alchemist_lvl NUMERIC(3) DEFAULT 1," +
                    "jb_alchemist_exp NUMERIC(7) DEFAULT 0," +

                    "CONSTRAINT fk_tb_job FOREIGN KEY(jb_player) REFERENCES tb_player(pl_uuid)" +
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
