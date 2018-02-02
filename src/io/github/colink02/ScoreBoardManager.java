package io.github.colink02;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;
import org.bukkit.scoreboard.Team.Option;
import org.bukkit.scoreboard.Team.OptionStatus;


public class ScoreBoardManager {
	private Team Killer;
	private Team Victims;
	private Scoreboard MainBoard;
	
	public void loadScoreBoard() {
		MainBoard = Bukkit.getScoreboardManager().getNewScoreboard();
		Killer = MainBoard.registerNewTeam("Killer");
		Victims = MainBoard.registerNewTeam("Runners");
		//Init Killer Team
		Objective obj = MainBoard.registerNewObjective("Alive", "dummy");
		obj.setDisplayName(ChatColor.RED.toString() + ChatColor.BOLD + "Murder Run");
		obj.setDisplaySlot(DisplaySlot.SIDEBAR);
		Killer.setAllowFriendlyFire(false);
		Killer.setOption(Option.COLLISION_RULE, OptionStatus.NEVER);
		Killer.setOption(Option.NAME_TAG_VISIBILITY, OptionStatus.FOR_OWN_TEAM);
		Killer.setColor(ChatColor.RED);
		//Init 
		Victims.setAllowFriendlyFire(false);
		Victims.setOption(Option.COLLISION_RULE, OptionStatus.NEVER);
		Victims.setOption(Option.NAME_TAG_VISIBILITY, OptionStatus.FOR_OWN_TEAM);
		Victims.setColor(ChatColor.GREEN);
	}
}
