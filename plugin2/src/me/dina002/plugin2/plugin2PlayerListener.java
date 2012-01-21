package me.dina002.plugin2;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerBedLeaveEvent;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerListener;


public class plugin2PlayerListener extends PlayerListener{
	
		
	public plugin2 plugin;
	public plugin2PlayerListener(plugin2 instance){
		
		plugin = instance;
		}	
	public void onPlayerJoin(PlayerJoinEvent event){
		Player player = event.getPlayer();
		
		if(!(player == null)){
			System.out.println ("Du er ikke i spillet");
		}
		player.sendMessage(ChatColor.GOLD + "Hei velkommen til Serveren " + player.getDisplayName());
		event.setJoinMessage(player.getDisplayName() + ChatColor.GREEN + (" Logget På"));
		
		
	}
	public void onPlayerBedEnter(PlayerBedEnterEvent event){
		Player player = event.getPlayer();
		player.sendMessage(ChatColor.AQUA + "God natt " + ChatColor.BLUE + player.getDisplayName());
	}
	public void onPlayerBedLeave(PlayerBedLeaveEvent event){
		Player player = event.getPlayer();
		player.sendMessage(ChatColor.AQUA + "God Morgen " + ChatColor.BLUE + player.getDisplayName());
	}
	public void onPlayerChat(PlayerChatEvent e){
		
	}
	}