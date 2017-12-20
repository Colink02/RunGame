public class MurderRunCommands() implement CommandExecutor {
  MurderRun main = new MurderRun();
  @Override
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    Player p = (Player) sender;
    if(args[0] == "start") {
      if(pamount < main.getConfig().getInt("Misc.PlayersMin") {
        p.sendMessage(ChatColor.RED + "Error: Not enough players!");
        main.gameStatus("DISABLED");
      }
    } else if(args[0] == "forcestart"){
        if(pamount < main.getconfig().getInt("Misc.PlayersMin") {
          p.sendMessage(ChatColor.ORANGE + ChatColor.BOLD + "Warning" + ChatColor.RESET + ChatColor.ORANGE + "Not many players! "); 
        } else if(pamount < 2) {
           p.sendMessage(ChatColor.RED + "Error: Can't force start as their is " + main.getConfig().getInt("Misc.PlayersMin") + " players required");
        }
    } else if(args[0] == "stop") {
    
    } else if(args[0] == "reload") {
      main.reloadConfig();
      main.getPlayer().sendMessage(ChatColor.GREEN + "Ok, Complete!");
    }
}
