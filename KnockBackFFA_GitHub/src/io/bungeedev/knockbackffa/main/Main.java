package io.bungeedev.knockbackffa.main;

import io.bungeedev.knockbackffa.listener.BlockListener;
import io.bungeedev.knockbackffa.listener.ChatListener;
import io.bungeedev.knockbackffa.listener.PlayerListener;
import io.bungeedev.knockbackffa.mysql.MySQL;
import java.io.File;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @author BungeeDev
 */
public class Main extends JavaPlugin {
 
    public static Main Instance;
    
    @Override
    public void onEnable() {
        Instance = this;
        if (!new File(getDataFolder(), "config.yml").exists()) {
        saveResource("config.yml", true);
    }
        MySQL.connect();
        MySQL.createTable();
        MySQL.createTableBanSystem();
        MySQL.createTableMuteSystem();
        MySQL.createTableRound();
        registerEvents();
        registerCommands();
    }
    public void registerEvents() {
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new PlayerListener(), this);
        pm.registerEvents(new ChatListener(), this);
        pm.registerEvents(new BlockListener(), this);
    }
    public void registerCommands() {
        
    }
    @Override
    public void onDisable() {
        
    }
    public static Main getKBF() {
        return Instance;
    }
    public String Prefix = ChatColor.translateAlternateColorCodes('&', getConfig().getString("KnockBackFFA.Prefix"));
    public String LevelName = ChatColor.translateAlternateColorCodes('&', getConfig().getString("KnockBackFFA.LevelName"));
    public boolean AllowJoinMessage = getConfig().getBoolean("KnockBackFFA.AllowJoinMessage");
    public boolean AllowQuitMessage = getConfig().getBoolean("KnockBackFFA.AllowQuitMessage");
    public boolean BungeeCord = getConfig().getBoolean("KnockBackFFA.BungeeCord");
    public boolean AllowBlockBreak = getConfig().getBoolean("KnockBackFFA.AllowBlockBreak");
    public boolean AllowBlockPlace = getConfig().getBoolean("KnockBackFFA.AllowBlockPlace");
    public boolean AllowServerChat = getConfig().getBoolean("KnockBackFFA.AllowServerChat");
    public int MaxPlayers = getConfig().getInt("KnockBackFFA.MaxPlayers");
    public String JoinMessage = ChatColor.translateAlternateColorCodes('&', getConfig().getString("Messages.JoinMessage"));
    public String QuitMessage = ChatColor.translateAlternateColorCodes('&', getConfig().getString("Messages.QuitMessage"));
    public String TitleHeader = ChatColor.translateAlternateColorCodes('&', getConfig().getString("Title.Header"));
    public String TitleFooter = ChatColor.translateAlternateColorCodes('&', getConfig().getString("Title.Footer"));
    public String TabHeader = ChatColor.translateAlternateColorCodes('&', getConfig().getString("Tablist.Header"));
    public String TabFooter = ChatColor.translateAlternateColorCodes('&', getConfig().getString("Tablist.Footer"));
    public String ScoreTitle = ChatColor.translateAlternateColorCodes('&', getConfig().getString("Scoreboard.Title"));
    public String User = ChatColor.translateAlternateColorCodes('&', getConfig().getString("MySQL.Username"));
    public String Password = ChatColor.translateAlternateColorCodes('&', getConfig().getString("MySQL.Password"));
    public String Host = ChatColor.translateAlternateColorCodes('&', getConfig().getString("MySQL.Host"));
    public String Datenbank = ChatColor.translateAlternateColorCodes('&', getConfig().getString("MySQL.Datenbank"));
    public String Port = ChatColor.translateAlternateColorCodes('&', getConfig().getString("MySQL.Port"));
    public String Owner = ChatColor.translateAlternateColorCodes('&', getConfig().getString("Group-Prefix.Owner"));
    public String Admin = ChatColor.translateAlternateColorCodes('&', getConfig().getString("Group-Prefix.Admin"));
    public String SrDev = ChatColor.translateAlternateColorCodes('&', getConfig().getString("Group-Prefix.SrDeveloper"));
    public String Dev = ChatColor.translateAlternateColorCodes('&', getConfig().getString("Group-Prefix.Developer"));
    public String SrMod = ChatColor.translateAlternateColorCodes('&', getConfig().getString("Group-Prefix.SrModerator"));
    public String Mod = ChatColor.translateAlternateColorCodes('&', getConfig().getString("Group-Prefix.Moderator"));
    public String SrSupp = ChatColor.translateAlternateColorCodes('&', getConfig().getString("Group-Prefix.SrSupporter"));
    public String Supp = ChatColor.translateAlternateColorCodes('&', getConfig().getString("Group-Prefix.Supporter"));
    public String SrBuilder = ChatColor.translateAlternateColorCodes('&', getConfig().getString("Group-Prefix.SrBuilder"));
    public String Builder = ChatColor.translateAlternateColorCodes('&', getConfig().getString("Group-Prefix.Builder"));
    public String YouTuber = ChatColor.translateAlternateColorCodes('&', getConfig().getString("Group-Prefix.YouTuber"));
    public String Premium = ChatColor.translateAlternateColorCodes('&', getConfig().getString("Group-Prefix.Premium"));
    public String Spieler = ChatColor.translateAlternateColorCodes('&', getConfig().getString("Group-Prefix.Player"));
}