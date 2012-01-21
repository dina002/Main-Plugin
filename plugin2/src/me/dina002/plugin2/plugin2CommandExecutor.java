package me.dina002.plugin2;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class plugin2CommandExecutor<ArrayList> implements CommandExecutor {
	plugin2 plugin;
	public final HashMap<Player, ArrayList> afkusers = new HashMap<Player, ArrayList>();

	public plugin2CommandExecutor(plugin2 instance) {
		plugin = instance;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String commandlabel, String[] args) {
		World world = null;
		Player player = (Player) sender;

		if (sender instanceof Player) {
			if (args.length == 2) {
				world = Bukkit.getWorld(args[1]);
			} else {
				world = ((Player) sender).getWorld();
			}
		} else if (sender instanceof ConsoleCommandSender) {
			if (args.length == 2) {
				world = Bukkit.getWorld(args[1]);
			} else {
				sender.sendMessage("Skriv inn verden navn !");
				return false;
			}
		}

		if (args.length >= 1 && world != null) {
			if (args[0].equalsIgnoreCase("sol")) {
				world.setStorm(false);
				player.getServer().broadcastMessage(ChatColor.GOLD + player.getDisplayName() + ChatColor.GREEN + " Satte været til sol");
				return true;
			} else if (args[0].equalsIgnoreCase("regn")) {
				world.setStorm(true);
				player.getServer().broadcastMessage(ChatColor.GOLD + player.getDisplayName() + ChatColor.GREEN + " Satte været til regn");
				return true;
			} else if (args[0].equalsIgnoreCase("storm")) {
				world.setStorm(true);
				world.setThundering(true);
				player.getServer().broadcastMessage(ChatColor.GOLD + player.getDisplayName() + ChatColor.GREEN + " Satte været til storm");
				return true;
			}
		}else if(commandlabel.equalsIgnoreCase("AFK")){
			  toggleAFK((Player)sender);
			  return true;
		}

		return false;
	}
	public void toggleAFK(Player player){
		if (enabled(player)){
			this.afkusers.remove(player);
			player.getServer().broadcastMessage(ChatColor.YELLOW + player.getDisplayName() + " er nå afk");
		}else{
			this.afkusers.put(player, null);
			player.getServer().broadcastMessage(ChatColor.YELLOW + player.getDisplayName() + " er ikke lenger afk");
		}
		
	}
	public boolean enabled(Player player){
		return this.afkusers.containsKey(player);
	}
}