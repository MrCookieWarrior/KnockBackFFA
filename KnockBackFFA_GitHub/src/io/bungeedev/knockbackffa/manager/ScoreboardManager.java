package io.bungeedev.knockbackffa.manager;

import io.bungeedev.knockbackffa.api.RoundStats;
import io.bungeedev.knockbackffa.api.StatsAPI;
import io.bungeedev.knockbackffa.main.Main;
import java.util.HashMap;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;
import ru.tehkode.permissions.bukkit.PermissionsEx;

/**
 * @author BungeeDev
 **/
public class ScoreboardManager {
    private Main plugin;
    public static Scoreboard board;
    public static HashMap<Scoreboard, Player> boards = new HashMap();
    
    public ScoreboardManager(Main plugin) {
        this.plugin = plugin;
    }
    public static void setScoreboard(Player p) {
        board = Bukkit.getScoreboardManager().getNewScoreboard();

        Objective obj = board.registerNewObjective("test", "bbb");

        obj.setDisplaySlot(DisplaySlot.SIDEBAR);
        obj.setDisplayName(Main.getKBF().ScoreTitle);

        obj.getScore("§l      ").setScore(14);
        obj.getScore("§7Online Players:").setScore(13);
        obj.getScore("§l    ").setScore(11);
        obj.getScore("§7Deine Coins:").setScore(10);
        obj.getScore("§l").setScore(8);
        obj.getScore("§7Deine Kills:").setScore(7);
        obj.getScore("§l ").setScore(5);
        obj.getScore("§7Deine Tode:").setScore(4);
        obj.getScore("§l  ").setScore(2);
        obj.getScore("§7TeamSpeak:").setScore(1);
        obj.getScore("").setScore(0);
        
        p.setScoreboard(board);
        
            Team owner = board.registerNewTeam("aaa");
            Team admin = board.registerNewTeam("bbb");
            Team srdeveloper = board.registerNewTeam("ccc");
            Team developer = board.registerNewTeam("ddd");
            Team srmoderator = board.registerNewTeam("eee");
            Team moderator = board.registerNewTeam("fff");
            Team srsupporter = board.registerNewTeam("ggg");
            Team supporter = board.registerNewTeam("hhh");
            Team srbuilder = board.registerNewTeam("iii");
            Team builder = board.registerNewTeam("jjj");
            Team youtuber = board.registerNewTeam("kkk");
            Team premium = board.registerNewTeam("lll");
            Team spieler = board.registerNewTeam("mmm");
            
            for (Player all : Bukkit.getOnlinePlayers()) {
			if (PermissionsEx.getUser(all).inGroup("Owner")) {
				owner.setPrefix(Main.getKBF().Owner);
				owner.addPlayer(all);				
			} else if (PermissionsEx.getUser(all).inGroup("Admin")) {
				admin.setPrefix(Main.getKBF().Admin);
				admin.addPlayer(all);
			} else if (PermissionsEx.getUser(all).inGroup("SrDeveloper")) {
				srdeveloper.setPrefix(Main.getKBF().SrDev);
				srdeveloper.addPlayer(all);
			} else if (PermissionsEx.getUser(all).inGroup("Developer")) {
				developer.setPrefix(Main.getKBF().Dev);
				developer.addPlayer(all);
			} else if (PermissionsEx.getUser(all).inGroup("SrModerator")) {
				srmoderator.setPrefix(Main.getKBF().SrMod);
				srmoderator.addPlayer(all);
			} else if (PermissionsEx.getUser(all).inGroup("Moderator")) {
				moderator.setPrefix(Main.getKBF().Mod);
				moderator.addPlayer(all);
			} else if (PermissionsEx.getUser(all).inGroup("SrSupporter")) {
				srsupporter.setPrefix(Main.getKBF().SrSupp);
				srsupporter.addPlayer(all);
			} else if (PermissionsEx.getUser(all).inGroup("Supporter")) {
				supporter.setPrefix(Main.getKBF().Supp);
				supporter.addPlayer(all);
			} else if (PermissionsEx.getUser(all).inGroup("SrBuilder")) {
				srbuilder.setPrefix(Main.getKBF().SrBuilder);
				srbuilder.addPlayer(all);
			} else if (PermissionsEx.getUser(all).inGroup("Builder")) {
				builder.setPrefix(Main.getKBF().Builder);
				builder.addPlayer(all);
			} else if (PermissionsEx.getUser(all).inGroup("YouTuber")) {
				youtuber.setPrefix(Main.getKBF().YouTuber);
				youtuber.addPlayer(all);
			} else if (PermissionsEx.getUser(all).inGroup("Premium")) {
				premium.setPrefix(Main.getKBF().Premium);
				premium.addPlayer(all);
			}  else {
				spieler.setPrefix(Main.getKBF().Spieler);
				spieler.addPlayer(all);
			}
    }
	}
    public static void UpdateScoreboard(Player p) {
        board = p.getScoreboard();
        Objective obj = board.getObjective("test");
        
        obj.getScore("§a" + RoundStats.getDeaths(p.getUniqueId().toString(), p.getName())).setScore(3);
        obj.getScore("§e" + RoundStats.getKills(p.getUniqueId().toString(), p.getName())).setScore(6);
        obj.getScore("§e" + Bukkit.getOnlinePlayers().size() + " §8/ §a" + Bukkit.getMaxPlayers()).setScore(12);
        obj.getScore("§e" + StatsAPI.getCoins(p.getUniqueId().toString(), p.getName())).setScore(9);
    }
	public static void setScoreNull(Player p) {
        p.setScoreboard(null);
        
            Team owner = board.registerNewTeam("aaa");
            Team admin = board.registerNewTeam("bbb");
            Team srdeveloper = board.registerNewTeam("ccc");
            Team developer = board.registerNewTeam("ddd");
            Team srmoderator = board.registerNewTeam("eee");
            Team moderator = board.registerNewTeam("fff");
            Team srsupporter = board.registerNewTeam("ggg");
            Team supporter = board.registerNewTeam("hhh");
            Team srbuilder = board.registerNewTeam("iii");
            Team builder = board.registerNewTeam("jjj");
            Team youtuber = board.registerNewTeam("kkk");
            Team premium = board.registerNewTeam("lll");
            Team spieler = board.registerNewTeam("mmm");
		
		for (Player all : Bukkit.getOnlinePlayers()) {
			if (PermissionsEx.getUser(all).inGroup("Owner")) {
				owner.setPrefix(Main.getKBF().Owner);
				owner.addPlayer(all);				
			} else if (PermissionsEx.getUser(all).inGroup("Admin")) {
				admin.setPrefix(Main.getKBF().Admin);
				admin.addPlayer(all);
			} else if (PermissionsEx.getUser(all).inGroup("SrDeveloper")) {
				srdeveloper.setPrefix(Main.getKBF().SrDev);
				srdeveloper.addPlayer(all);
			} else if (PermissionsEx.getUser(all).inGroup("Developer")) {
				developer.setPrefix(Main.getKBF().Dev);
				developer.addPlayer(all);
			} else if (PermissionsEx.getUser(all).inGroup("SrModerator")) {
				srmoderator.setPrefix(Main.getKBF().SrMod);
				srmoderator.addPlayer(all);
			} else if (PermissionsEx.getUser(all).inGroup("Moderator")) {
				moderator.setPrefix(Main.getKBF().Mod);
				moderator.addPlayer(all);
			} else if (PermissionsEx.getUser(all).inGroup("SrSupporter")) {
				srsupporter.setPrefix(Main.getKBF().SrSupp);
				srsupporter.addPlayer(all);
			} else if (PermissionsEx.getUser(all).inGroup("Supporter")) {
				supporter.setPrefix(Main.getKBF().Supp);
				supporter.addPlayer(all);
			} else if (PermissionsEx.getUser(all).inGroup("SrBuilder")) {
				srbuilder.setPrefix(Main.getKBF().SrBuilder);
				srbuilder.addPlayer(all);
			} else if (PermissionsEx.getUser(all).inGroup("Builder")) {
				builder.setPrefix(Main.getKBF().Builder);
				builder.addPlayer(all);
			} else if (PermissionsEx.getUser(all).inGroup("YouTuber")) {
				youtuber.setPrefix(Main.getKBF().YouTuber);
				youtuber.addPlayer(all);
			} else if (PermissionsEx.getUser(all).inGroup("Premium")) {
				premium.setPrefix(Main.getKBF().Premium);
				premium.addPlayer(all);
			}  else {
				spieler.setPrefix(Main.getKBF().Spieler);
				spieler.addPlayer(all);
			}
    }
	}
    }