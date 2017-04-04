/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.bungeedev.knockbackffa.main;

import org.bukkit.ChatColor;
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
        registerEvents();
        registerCommands();
    }
    public void registerEvents() {
        
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
    public boolean AllowJoinMessage = getConfig().getBoolean("KnockBackFFA.AllowJoinMessage");
    public boolean AllowQuitMessage = getConfig().getBoolean("KnockBackFFA.AllowQuitMessage");
    public boolean BungeeCord = getConfig().getBoolean("KnockBackFFA.BungeeCord");
    public boolean AllowBlockBreak = getConfig().getBoolean("KnockBackFFA.AllowBlockBreak");
    public boolean AllowBlockPlace = getConfig().getBoolean("KnockBackFFA.AllowBlockPlace");
    public boolean EnableBanSystem = getConfig().getBoolean("KnockBackFFA.EnableBanSystem");
    public boolean EnableMuteSystem = getConfig().getBoolean("KnockBackFFA.EnableMuteSystem");
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
}