package io.bungeedev.knockbackffa.listener;

import io.bungeedev.knockbackffa.api.ItemAPI;
import io.bungeedev.knockbackffa.main.Main;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

/**
 * @author BungeeDev
 **/
public class PlayerListener implements Listener {
    
    @EventHandler
    public void onLogin(PlayerLoginEvent e) {
        
    }    
    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        e.getPlayer().getInventory().setItem(0, ItemAPI.createjoinItem(Material.STICK, 1, 0, "§3KnockBackStick", Enchantment.KNOCKBACK, 1));
        if(Main.getKBF().AllowJoinMessage == true) {
            String join = Main.getKBF().JoinMessage;
            join = join.replaceFirst("%player%", e.getPlayer().getDisplayName());
            e.setJoinMessage(join);
        } else {
            e.setJoinMessage(null);
        }
    }
    @EventHandler
    public void onDeath(PlayerDeathEvent e) {
        
    }
    @EventHandler
    public void onRespawn(PlayerRespawnEvent e) {
        
    }
    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        if(Main.getKBF().AllowQuitMessage == true) {
            String quit = Main.getKBF().QuitMessage;
            quit = quit.replaceFirst("%player%", e.getPlayer().getDisplayName());
            e.setQuitMessage(quit);
        } else {
            e.setQuitMessage(null);
        }
    }
}