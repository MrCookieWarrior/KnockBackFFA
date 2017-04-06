package io.bungeedev.knockbackffa.listener;

import io.bungeedev.knockbackffa.api.ItemAPI;
import io.bungeedev.knockbackffa.api.RoundStats;
import io.bungeedev.knockbackffa.api.StatsAPI;
import io.bungeedev.knockbackffa.main.Main;
import io.bungeedev.knockbackffa.manager.ScoreboardManager;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.scheduler.BukkitRunnable;

/**
 * @author BungeeDev
 **/
public class PlayerListener implements Listener {
    
    @EventHandler
    public void onLogin(PlayerLoginEvent e) {
        
    }    
    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        if(!RoundStats.playerExists(p.getUniqueId().toString())) {
            RoundStats.createPlayer(p.getUniqueId().toString(), e.getPlayer().getName());
        }
        RoundStats.setDeaths(p.getUniqueId().toString(), e.getPlayer().getName(), 0);
        RoundStats.setKills(p.getUniqueId().toString(), e.getPlayer().getName(), 0);
        new BukkitRunnable() {
            @Override
            public void run() {
                for(Player all : Bukkit.getOnlinePlayers()) {
                    ScoreboardManager.setScoreboard(all);
                    ScoreboardManager.UpdateScoreboard(all);
                }
            }
        }.runTaskLater(Main.getKBF(), 1);
        p.getInventory().setItem(0, ItemAPI.createjoinItem(Material.STICK, 1, 0, "§3KnockBackStick", Enchantment.KNOCKBACK, 1));
        p.getInventory().setItem(Main.getKBF().BowItemSlot, ItemAPI.createjoinItem(Material.BOW, 1, 0, "§3KnockBackBow", Enchantment.ARROW_KNOCKBACK, 1));
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
    Player killer = e.getEntity().getKiller();
    Player opfer = e.getEntity().getPlayer();
    opfer.spigot().respawn();
    if (killer == null) {
      StatsAPI.addDeaths(opfer.getUniqueId().toString(), opfer.getName(), 1);
      StatsAPI.removeCoins(opfer.getUniqueId().toString(), opfer.getName(), 2);
      RoundStats.addDeaths(opfer.getUniqueId().toString(), opfer.getName(), 1);
      Bukkit.broadcastMessage(Main.getKBF().Prefix + "§3Der §e" + opfer.getDisplayName() + " §3ist gestorben!");
      ScoreboardManager.setScoreboard(opfer);
      ScoreboardManager.UpdateScoreboard(opfer);
      opfer.getInventory().setItem(0, ItemAPI.createjoinItem(Material.STICK, 1, 0, "§3KnockBackStick", Enchantment.KNOCKBACK, 1));
      opfer.getInventory().setItem(Main.getKBF().BowItemSlot, ItemAPI.createjoinItem(Material.BOW, 1, 0, "§3KnockBackBow", Enchantment.ARROW_KNOCKBACK, 1));
    } else {
      Bukkit.broadcastMessage(Main.getKBF().Prefix + "§3Der §e" + opfer.getDisplayName() + " §3wurde von dem §a" + killer.getDisplayName() + " §3getötet!");
      e.setDeathMessage(null);
      RoundStats.addDeaths(opfer.getUniqueId().toString(), opfer.getName(), 1);
      RoundStats.addKills(killer.getUniqueId().toString(), killer.getName(), 1);
      StatsAPI.addCoins(killer.getUniqueId().toString(), killer.getName(), 10);
      StatsAPI.addKills(killer.getUniqueId().toString(), killer.getName(), 1);
      StatsAPI.removeCoins(opfer.getUniqueId().toString(), opfer.getName(), 5);
      StatsAPI.addDeaths(opfer.getUniqueId().toString(), opfer.getName(), 1);
      opfer.getInventory().clear();
      ScoreboardManager.setScoreboard(opfer);
      ScoreboardManager.UpdateScoreboard(opfer);
      opfer.getInventory().setItem(0, ItemAPI.createjoinItem(Material.STICK, 1, 0, "§3KnockBackStick", Enchantment.KNOCKBACK, 1));
      opfer.getInventory().setItem(Main.getKBF().BowItemSlot, ItemAPI.createjoinItem(Material.BOW, 1, 0, "§3KnockBackBow", Enchantment.ARROW_KNOCKBACK, 1));
      ScoreboardManager.setScoreboard(killer);
      ScoreboardManager.UpdateScoreboard(killer);
    }
  }
    @EventHandler
    public void onRespawn(PlayerRespawnEvent e) {
        Player p = e.getPlayer();
        ScoreboardManager.setScoreboard(p);
        ScoreboardManager.UpdateScoreboard(p);
    }
    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        new BukkitRunnable() {
            @Override
            public void run() {
                for(Player all : Bukkit.getOnlinePlayers()) {
                    ScoreboardManager.setScoreboard(all);
                    ScoreboardManager.UpdateScoreboard(all);
                }
            }
        }.runTaskLater(Main.getKBF(), 1);
        if(Main.getKBF().AllowQuitMessage == true) {
            String quit = Main.getKBF().QuitMessage;
            quit = quit.replaceFirst("%player%", e.getPlayer().getDisplayName());
            e.setQuitMessage(quit);
        } else {
            e.setQuitMessage(null);
        }
    }
}