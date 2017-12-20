public class MurderRunCommands() implement CommandExecutor {
  MurderRun main = new MurderRun();
  @Override
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    Player p = (Player) sender;
    if(args[0] == "start") {
    
    } else if(args[0] == "forcestart"){
    
    } else if(args[0] == "stop") {
    
    } else if(args[0] == "reload") {
      main.reloadConfig();
      main.getPlayer().sendMessage(ChatColor.GREEN + "Ok, Complete!");
    }
}
