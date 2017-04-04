package io.bungeedev.knockbackffa.listener;

import io.bungeedev.knockbackffa.main.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import ru.tehkode.permissions.bukkit.PermissionsEx;

/**
 * @author BungeeDev
 **/
public class ChatListener implements Listener {
    
    @EventHandler
    public void onPrefix(AsyncPlayerChatEvent e) {
        Player p = e.getPlayer();
        String msg = e.getMessage();
        
        if(PermissionsEx.getUser(p).inGroup("Owner")) {
            e.setFormat(Main.getKBF().Owner + p.getDisplayName() + " §7» " + msg);
        } else if(PermissionsEx.getUser(p).inGroup("Admin")) {
            e.setFormat(Main.getKBF().Admin + p.getDisplayName() + " §7» " + msg);
        } else if(PermissionsEx.getUser(p).inGroup("SrDeveloper")) {
            e.setFormat(Main.getKBF().SrDev + p.getDisplayName() + " §7» " + msg);
        } else if(PermissionsEx.getUser(p).inGroup("Developer")) {
            e.setFormat(Main.getKBF().Dev + p.getDisplayName() + " §7» " + msg);
        } else if(PermissionsEx.getUser(p).inGroup("SrModerator")) {
            e.setFormat(Main.getKBF().SrMod + p.getDisplayName() + " §7» " + msg);
        } else if(PermissionsEx.getUser(p).inGroup("Moderator")) {
            e.setFormat(Main.getKBF().Mod + p.getDisplayName() + " §7» " + msg);
        } else if(PermissionsEx.getUser(p).inGroup("SrSupporter")) {
            e.setFormat(Main.getKBF().SrSupp + p.getDisplayName() + " §7» " + msg);
        } else if(PermissionsEx.getUser(p).inGroup("Supporter")) {
            e.setFormat(Main.getKBF().Supp + p.getDisplayName() + " §7» " + msg);
        } else if(PermissionsEx.getUser(p).inGroup("SrBuilder")) {
            e.setFormat(Main.getKBF().SrBuilder + p.getDisplayName() + " §7» " + msg);
        } else if(PermissionsEx.getUser(p).inGroup("Builder")) {
            e.setFormat(Main.getKBF().Builder + p.getDisplayName() + " §7» " + msg);
        } else if(PermissionsEx.getUser(p).inGroup("YouTuber")) {
            e.setFormat(Main.getKBF().YouTuber + p.getDisplayName() + " §7» " + msg);
        } else if(PermissionsEx.getUser(p).inGroup("Premium")) {
            e.setFormat(Main.getKBF().Premium + p.getDisplayName() + " §7» " + msg);
        } else {
            e.setFormat(Main.getKBF().Spieler + p.getDisplayName() + " §7» " + msg);
        }
    }
    @EventHandler
    public void onServerChat(AsyncPlayerChatEvent e) {
        if((Main.getKBF().BungeeCord) && (Main.getKBF().AllowServerChat)) {
            e.setCancelled(true);
            e.getPlayer().sendMessage(Main.getKBF().Prefix + "§cDer ServerChat wurde auf dem Server deativiert!");
        } else if((!Main.getKBF().BungeeCord) && (Main.getKBF().AllowServerChat)) {
            Player p = e.getPlayer();
            if(p.getWorld().getName().contains(Main.getKBF().LevelName)) {
                e.setCancelled(true);
                p.sendMessage(Main.getKBF().Prefix + "§cDer Chat wurde auf dieser Welt ausgeschaltet!");
            }
        } else {
            e.setCancelled(false);
        }
    }
}