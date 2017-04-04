package io.bungeedev.knockbackffa.listener;

import io.bungeedev.knockbackffa.main.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

/**
 * @author BungeeDev
 **/
public class BlockListener implements Listener {
    
    @EventHandler
    public void onBreak(BlockBreakEvent e) {
        if(Main.getKBF().BungeeCord == true && Main.getKBF().AllowBlockBreak == false) {
            e.setCancelled(true);
        } else if(Main.getKBF().BungeeCord == false && Main.getKBF().AllowBlockBreak == false) {
            Player p = e.getPlayer();
            if(p.getWorld().getName().contains(Main.getKBF().LevelName)) {
                e.setCancelled(true);
            } else {
                e.setCancelled(false);
            }
        }
    }
    @EventHandler
    public void onPlace(BlockPlaceEvent e) {
        if(Main.getKBF().BungeeCord == true && Main.getKBF().AllowBlockPlace == false) {
            e.setCancelled(true);
        } else if(Main.getKBF().BungeeCord == false && Main.getKBF().AllowBlockPlace == false) {
            Player p = e.getPlayer();
            if(p.getWorld().getName().contains(Main.getKBF().LevelName)) {
                e.setCancelled(true);
            } else {
                e.setCancelled(false);
            }
        }
    }
}