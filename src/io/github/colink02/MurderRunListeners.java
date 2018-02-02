package io.github.colink02;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import net.md_5.bungee.api.ChatColor;

public class MurderRunListeners implements Listener {
	
	 MurderRun main = new MurderRun();

	@EventHandler
	public void OnPlayerJoin(PlayerJoinEvent p) {
		World gameWorld = Bukkit.getServer().getWorld(main.getConfig().getString("Misc.Game-World"));
		if(p.getPlayer().getWorld().equals(gameWorld)) {
			Player playerName = p.getPlayer();
			World mainWorld = Bukkit.getServer().getWorld(main.getConfig().getString("misc.Main-World"));
			Location loc = new Location(gameWorld ,(main.getConfig().getDouble("Spawn.Spawn-X")),(main.getConfig().getDouble("Spawn.Spawn-Y")),(main.getConfig().getDouble("Spawn.Spawn-Z")));
			switch(main.gameStatus) 
			{
				case "INGAME":
					playerName.sendMessage(ChatColor.RED + "[Murder Run] Game is still running please wait...");
					playerName.setGameMode(GameMode.SPECTATOR);
					break;
				case "LOBBY":
					playerName.teleport(loc);
					break;
				case "DISABLED":
					Location teleportLocation = new Location(mainWorld, mainWorld.getSpawnLocation().getX(), mainWorld.getSpawnLocation().getY(), mainWorld.getSpawnLocation().getZ());
					playerName.sendMessage("Game has been Disabled for now!");
					playerName.teleport(teleportLocation);
					break;
			}
		}
	}
	@EventHandler
	public void OnKillEvent(PlayerDeathEvent e) {
		if(main.gameStatus == "INGAME") {
			e.getEntity().setGameMode(GameMode.SPECTATOR);
			Bukkit.getServer().getWorld(main.config.getString("GameWorld"));
		}
	}
		
	
	
}
