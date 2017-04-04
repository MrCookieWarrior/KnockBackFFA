package io.bungeedev.knockbackffa.mysql;

import io.bungeedev.knockbackffa.main.Main;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

/**
 *
 * @author BungeeDev
 */

public class MySQL
{
  public static String username;
  public static String password;
  public static String database;
  public static String host;
  public static String port;
  public static Connection con;
    
  public static void connect()
  {
    if (!isConnected()) {
      try
      {
        con = DriverManager.getConnection("jdbc:mysql://" + Main.getKBF().Host + ":" + Main.getKBF().Port + "/" + Main.getKBF().Datenbank + "?user=" + Main.getKBF().User + "&password=" + Main.getKBF().Password + "&autoReconnect=true");
        Bukkit.getConsoleSender().sendMessage("§7[§3MySQL§7] §eThe database succesfully connected!");
      }
      catch (SQLException e)
      {
        Bukkit.getConsoleSender().sendMessage("§7[§3MySQL§7] §4ERROR: the connection has been error! §3Please contact the Plugin Developer -> BungeeDev!");
      }
    }
  }
  
  public static void close()
  {
    if (isConnected()) {
      try
      {
        con.close();
        Bukkit.getConsoleSender().sendMessage("§7[§3MySQL§7] §cThe database succesfully disconnected!");
      }
      catch (SQLException e)
      {
        Bukkit.getConsoleSender().sendMessage("§7[§3MySQL§7] §4ERROR: §cthe connection has been error! Please contact the Plugin Developer -> BungeeDev");
      }
    }
  }
  
  public static boolean isConnected()
  {
    return con != null;
  }
  
  public static void createTable()
  {
    if (isConnected()) {
      try
      {
        con.createStatement().executeUpdate("CREATE TABLE IF NOT EXISTS Stats (UUID VARCHAR(100), NAME VARCHAR(100), KILLS int, DEATHS int , WIN int , LOSE int , COINS int)");
        Bukkit.getConsoleSender().sendMessage("§7[§3MySQL§7] Stats Table created");
      }
      catch (SQLException e)
      {
        e.printStackTrace();
      }
    }
  }
  
  public static void createTableRound()
  {
    if (isConnected()) {
      try
      {
        con.createStatement().executeUpdate("CREATE TABLE IF NOT EXISTS EasyServerManager (UUID VARCHAR(100), NAME VARCHAR(100), KILLS int, DEATHS int)");
        
        Bukkit.getConsoleSender().sendMessage("§7[§3MySQL§7] EasyServerManager Table created");
      }
      catch (SQLException e)
      {
        e.printStackTrace();
      }
    }
  }
  
  public static void createTableBanSystem()
  {
    if (isConnected()) {
      try
      {
        con.createStatement().executeUpdate("CREATE TABLE IF NOT EXISTS BannedPlayers (Spielername VARCHAR(100), UUID VARCHAR(100), Ende VARCHAR(100), Grund VARCHAR(100))");
        Bukkit.getConsoleSender().sendMessage("§7[§3MySQL§7] BannedPlayers Table created");
      }
      catch (SQLException e)
      {
        e.printStackTrace();
      }
    }
  }
  
  public static void createTableMuteSystem()
  {
    if (isConnected()) {
      try
      {
        con.createStatement().executeUpdate("CREATE TABLE IF NOT EXISTS MutePlayers (Spielername VARCHAR(100), UUID VARCHAR(100), Ende VARCHAR(100), Grund VARCHAR(100))");
        Bukkit.getConsoleSender().sendMessage("§7[§3MySQL§7] MutePlayers Table created");
      }
      catch (SQLException e)
      {
        e.printStackTrace();
      }
    }
  }
  
  public static void update(String qry)
  {
    if (isConnected()) {
      try
      {
        con.createStatement().executeUpdate(qry);
      }
      catch (SQLException e)
      {
        e.printStackTrace();
      }
    }
  }
  
  public static ResultSet getResult(String qry)
  {
    ResultSet rs = null;
    try
    {
      Statement st = con.createStatement();
      rs = st.executeQuery(qry);
    }
    catch (SQLException e)
    {
      connect();
      System.err.println(e);
    }
    return rs;
  }
  
  public static File getMySQLFile()
  {
    return new File("plugins/Lobby", "MySQL.yml");
  }
  
  public static FileConfiguration getMySQLFileConfiguration()
  {
    return YamlConfiguration.loadConfiguration(getMySQLFile());
  }
  
  public static void setStandardMySQL()
  {
    FileConfiguration cfg = getMySQLFileConfiguration();
    
    cfg.options().copyDefaults(true);
    cfg.addDefault("username", "root");
    cfg.addDefault("password", "password");
    cfg.addDefault("database", "localhost");
    cfg.addDefault("host", "localhost");
    cfg.addDefault("port", "3306");
    try
    {
      cfg.save(getMySQLFile());
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }
  
  public static void readMySQL()
  {
    FileConfiguration cfg = getMySQLFileConfiguration();
    username = cfg.getString("username");
    password = cfg.getString("password");
    database = cfg.getString("database");
    host = cfg.getString("host");
    port = cfg.getString("port");
  }
}
