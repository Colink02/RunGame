package io.github.colink02;

import org.bukkit.Bukkit;
import org.bukkit.Instrument;
import org.bukkit.Note;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import io.github.theluca98.textapi.Title;

public class MurderRunGame {
	private Team Killer;
	private Team Victims;
	private Scoreboard MainBoard;
	public static void main(String args[]) throws InterruptedException {
		int x = 10;
		while(x >= 1) {
			Title title = new Title("Game Starts in","" + x + "", 0, 1, 0);
			for(Player p : Bukkit.getOnlinePlayers()) {
				p.playNote(p.getLocation(),Instrument.CHIME , Note.natural(4, Note.Tone.E));
				title.send(p);
			}
			Thread.sleep(1000);
			x--;
		}
		Player Killer = Bukkit.getOnlinePlayers().iterator().next();
		for(Player p : Bukkit.getOnlinePlayers()) {
			if(!p.getName().equals(Killer)) {
				
			}
		}
	}
}
