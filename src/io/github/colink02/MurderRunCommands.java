package io.github.colink02;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MurderRunCommands {
	MurderRun main = new MurderRun();
	 public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
	    Player p = (Player) sender;
	    int pamount = main.getConfig().getInt("misc.MIN_Players");
	    if(args[0] == "start") {
	      if(pamount < main.getConfig().getInt("Misc.MIN_Players")) {
	        p.sendMessage(ChatColor.RED + "Error: Not enough players!");
	        main.gameStatus = "DISABLED";
	      }
	    } else if(args[0] == "forcestart"){
	        if(pamount < main.getConfig().getInt("Misc.MIN_Players")) {
	          p.sendMessage(" " + ChatColor.GOLD + ChatColor.BOLD +"Warning" + ChatColor.RESET + ChatColor.GOLD + "Not alot of players. Game may end quickly! "); 
	          return true;
	        } else if(pamount < 2) {
	           p.sendMessage(ChatColor.RED + "Error: Can't force start as their is " + main.getConfig().getInt("Misc.PlayersMin") + " players required");
	           return true;
	        }
	    } else if(args[0] == "stop") {
	    
	    	return true;
	    } else if(args[0] == "reload") {
	      main.reloadConfig();
	      p.sendMessage(ChatColor.GREEN + "Ok, Complete!");
	      return true;
	    }
	    return false;
	 }
}
	 
