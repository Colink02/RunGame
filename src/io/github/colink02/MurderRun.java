package io.github.colink02;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import io.github.theluca98.textapi.ActionBar;

public class MurderRun extends JavaPlugin{
	final FileConfiguration config = getConfig();
	ScoreBoardManager sbm = new ScoreBoardManager();
	public Logger log = getLogger();
	public String gameStatus = "LOBBY";
	public void onEnable() {
		reloadConfig();
		saveDefaultConfig();
		config.addDefault("Spawn.Spawn-X", 0.0);
		config.addDefault("Spawn.Spawn-y", 64.0);
		config.addDefault("Spawn.Spawn-Z", 0.0);
		config.addDefault("Game.Spawn-X", 156.0);
		config.addDefault("Game.Spawn-Y", 64.0);
		config.addDefault("Game.Spawn-Z", 156.0);
		config.addDefault("misc.MAX_Players", 4);
		config.addDefault("misc.Main-World", "MurderRun");
		config.addDefault("misc.MIN_Players", 2);
		saveConfig();
		System.out.println("Murder Run Plugin is Ready!");
		if(config.getInt("misc.MIN_Players") < 2) {
			config.set("misc.MIN_Players", 2);
			log.warning("MAX_Player config was less than 2, Auto setting back to default.");
		}
		sbm.loadScoreBoard();
		log.info("Plugin Loaded Fine! Everything seems ok...");
		ActionBar waiting = new ActionBar("Waiting in Lobby");
		while(gameStatus == "LOBBY") {
			String worldMain = config.getString("Main-World").toString();
			if(Bukkit.getWorld(worldMain).getPlayers().size() != config.getInt("misc.MIN_Players")) {
				waiting.sendToAll();
			} else if(Bukkit.getWorld(worldMain).getPlayers().size() == config.getInt("misc.MIN_Players")) {
				
			}
		}
	}
	public void onDisable() {
		System.out.println("Disabling Murder Run");
	}
}
