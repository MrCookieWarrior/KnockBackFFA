/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.bungeedev.knockbackffa.main;

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
}