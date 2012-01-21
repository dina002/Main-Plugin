package me.dina002.plugin2;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockListener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;

public class plugin2BlockListener extends BlockListener{
    
	public static plugin2 plugin;
    
    public plugin2BlockListener(plugin2 instance) {
            plugin = instance;
            }
	
	public void onBlockBreak(BlockBreakEvent event){
		Player player = event.getPlayer();
		Block block = event.getBlock();
		if(block.getType() == Material.DIAMOND_ORE){
			player.sendMessage("Du fant" + ChatColor.AQUA + " Diamant");
		}
		if (block.getType() == Material.TNT){
			if (event.isCancelled()) return;
			block.setType(Material.AIR);
			block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.CAKE, 1));
		}
			
		}
	public void onBlockPlace(BlockPlaceEvent event){
		if (event.isCancelled()) return;
		Player player = event.getPlayer();
		Block block = event.getBlock();
		
		if(block.getType() == Material.TNT){
			block.setType(Material.GRAVEL);
			
			player.sendMessage(ChatColor.RED + "TNT er ikke tillat !");
			
			plugin.logMessage(player.getName() + " Placed TNT at " + "X:" + block.getX() + " Y:" + block.getY() + " Z:" + block.getZ());
			}
		if (block.getType() == Material.LAVA){
				block.setType(Material.AIR);
				player.sendMessage("Lava er ikke tillat");
			}
		}
	}