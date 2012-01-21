package me.dina002.plugin2;
import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;


public class plugin2 extends JavaPlugin{
	
	private final plugin2PlayerListener playerListener = new plugin2PlayerListener(this);
	private final plugin2BlockListener blockListener = new plugin2BlockListener(this);
	Logger log = Logger.getLogger("Minecraft");
	
	public int damage;
	public int damaged;
	
	
	public void onEnable(){
	log.info("Din Plugin har blitt aktivert");	
	getCommand("himmel").setExecutor(new plugin2CommandExecutor<Object>(this));
	getCommand("afk").setExecutor(new plugin2CommandExecutor<Object>(this));
	getCommand("ping").setExecutor(new plugin2CommandExecutor<Object>(this));
	PluginManager pm = this.getServer().getPluginManager();
	pm.registerEvent(Event.Type.PLAYER_BUCKET_EMPTY, playerListener, Event.Priority.Normal, this);
	pm.registerEvent(Event.Type.PLAYER_JOIN, playerListener, Event.Priority.Normal, this);
	pm.registerEvent(Event.Type.BLOCK_BREAK, blockListener, Event.Priority.Normal, this);
	pm.registerEvent(Event.Type.PLAYER_CHAT, playerListener, Event.Priority.Normal, this);
	pm.registerEvent(Event.Type.PLAYER_BED_ENTER, playerListener, Event.Priority.Normal, this);
	pm.registerEvent(Event.Type.PLAYER_BED_LEAVE, playerListener, Event.Priority.Normal, this);
	pm.registerEvent(Event.Type.BLOCK_PLACE, blockListener, Event.Priority.Normal, this);
	}
	public void onDisable(){
		
		log.info("Din Plugin har blitt deaktivert");
	}
	
	protected void logMessage(String msg){
		PluginDescriptionFile pdFile = this.getDescription();
		this.log.info(pdFile.getName() + " " + pdFile.getVersion() + " : " + msg);
	}
	
	
	
public boolean onCommand(CommandSender sender, Command command, String commandlabel, String[] args){
		Player player = (Player) sender;
		damage = player.getHealth() - damaged;
		
		if(commandlabel.equalsIgnoreCase("selvmord")){
			player.setHealth(0);
			player.getServer().broadcastMessage(ChatColor.GOLD + player.getDisplayName() + ChatColor.YELLOW + " Tok Selvmord");
			
			}else if(commandlabel.equalsIgnoreCase("lyn") && hasPermission("plugin2.lyn") == false){
				player.getWorld().strikeLightning(player.getLocation());
				player.getServer().broadcastMessage(ChatColor.GOLD + player.getDisplayName() + ChatColor.YELLOW +(" Ble truffet av lynet"));
				}else if(commandlabel.equalsIgnoreCase("GiMeg") && hasPermission("plugin2.gimeg") == false){
								if (sender instanceof Player == false){
									sender.sendMessage("Denne /Gimeg kommandoen er kun tilgjengelig i spillet !");
									return true;
								}
							if (args.length == 0){
								return false;
							}
							if(args[0].matches("[-+]?\\d+(\\.\\d+)?") == false){
								return false;
							}
							
							if(args.length == 2 && args[1].matches("[-+]?\\d+(\\.\\d+)?") == false){
								return false;
							}
							int itemID = Integer.parseInt(args[0]);
							int amount = (args.length ==  2) ? Integer.parseInt(args[1]) : 64;
							if (Material.getMaterial(itemID) == null){
								sender.sendMessage(ChatColor.RED + "Det er ikke noe Item med den ID'en");
								return true;
							}
							ItemStack item = new ItemStack(itemID, amount);
							((Player) sender).getInventory().addItem(item);
						
		return true;
							}else if(commandlabel.equalsIgnoreCase("gimeginfo")){
									  if (args.length == 0){
										  return false;
									  }
									  if(args[0].equalsIgnoreCase("1")){
									  player.sendMessage(" ");
									  player.sendMessage(ChatColor.YELLOW + "----[" + ChatColor.GREEN + "Item ID's :" + ChatColor.YELLOW + "]----");
									  player.sendMessage("Stone ID = 1");
									  player.sendMessage("Grass Block ID = 2");
									  player.sendMessage("Dirt ID = 3");
									  player.sendMessage("CobbleStone ID = 4");
									  player.sendMessage("Wooden Planks ID = 5");
									  player.sendMessage("Sapling ID = 6");
									  player.sendMessage(" Bedrock ID = 7");
									  player.sendMessage("Water ID = 8/9");
									  player.sendMessage("Lava ID = 10/11");
									  player.sendMessage("Sand ID = 13");
									  player.sendMessage("Gold Ore ID = 14");
									  player.sendMessage("Iron Ore ID = 15");
									  player.sendMessage(" ");
									  player.sendMessage(ChatColor.GOLD + "/gimeginfo 2 for neste side");
									  }
									  if (args[0].equalsIgnoreCase("2")){
										  player.sendMessage(" ");
										  player.sendMessage(ChatColor.YELLOW + "----[" + ChatColor.GREEN + " Item ID's Side 2 : " + ChatColor.YELLOW + "]----");
										  player.sendMessage("Coal Ore ID = 16");
										  player.sendMessage("Wood ID = 17");
										  player.sendMessage("Leaves ID = 18");
										  player.sendMessage("Sponge ID = 19");
										  player.sendMessage("Glass ID = 20");
										  player.sendMessage("Lapiz Lasuli Ore ID = 21");
										  player.sendMessage("Lapiz Lasuli Block ID = 22");
										  player.sendMessage("Dispenser ID = 23");
										  player.sendMessage("Sandstone ID = 24");
										  player.sendMessage("Noteblock ID = 25");
										  player.sendMessage("Powered Rail ID = 27");
										  player.sendMessage("Detector Rail ID = 28");
										  player.sendMessage("Sticky Piston ID = 29");
										  player.sendMessage("Cobweb ID = 30");
										  player.sendMessage("Piston ID = 33");
										  player.sendMessage(" ");
										  player.sendMessage(ChatColor.GOLD + "/gimeginfo 3 for neste side");
									  }
										  if (args[0].equalsIgnoreCase("3")){
											  player.sendMessage(" ");
											  player.sendMessage(ChatColor.YELLOW + "----[" + ChatColor.GREEN + " Item ID's Side 3 : " + ChatColor.YELLOW + "]----");
										  player.sendMessage("Wool ID = 35 /gimeginfo wool");
										  player.sendMessage("Yellow Flower ID = 37");
										  player.sendMessage("Red Flower ID = 38");
										  player.sendMessage("Brown Mushroom ID = 39");
										  player.sendMessage("Red Mushroom ID = 40");
										  player.sendMessage("Gold Block ID = 41");
										  player.sendMessage("Iron Block ID = 42");
										  player.sendMessage("Double Slab ID = 43");
										  player.sendMessage("Stone Slab ID = 44");
										  player.sendMessage("Bricks ID = 45");
										  player.sendMessage("TnT ID = 46");
										  player.sendMessage("Bookshelf ID = 47");
										  player.sendMessage("Mossy Cobblestone ID = 48");
										  player.sendMessage("Obsidian ID = 49");
										  player.sendMessage("Torch ID = 50");
										  player.sendMessage(" ");
										  player.sendMessage(ChatColor.GOLD + "/gimeginfo 4 for neste side");
									  }
										  if (args[0].equalsIgnoreCase("4")){
											  player.sendMessage(" ");
											  player.sendMessage(ChatColor.YELLOW + "----[" + ChatColor.GREEN + " Item ID's Side 4 : " + ChatColor.YELLOW + "]----");
										  player.sendMessage("Fire ID = 51");
										  player.sendMessage("Monster Spawner ID = 52");
										  player.sendMessage("Wooden Stairs ID = 53");
										  player.sendMessage("Chest ID = 54");
										  player.sendMessage("Diamond Ore ID = 56");
										  player.sendMessage("Diamond Block ID = 57");
										  player.sendMessage("Workbench ID = 58");
										  player.sendMessage("Furnace ID = 61");
										  player.sendMessage("Ladder ID = 65");
										  player.sendMessage("Rail ID = 66");
										  player.sendMessage("Lever ID = 69");
										  player.sendMessage("Stone Pressure Plate ID = 70");
										  player.sendMessage("Wooden Pressure PLate ID = 72");
										  player.sendMessage("Redstone Ore ID = 73");
										  player.sendMessage("Redstone Torch ID = 75");
										  player.sendMessage(" ");
										  player.sendMessage(ChatColor.GOLD + "/gimeginfo 5 for neste side");
									  }
										  if (args[0].equalsIgnoreCase("5")){
											  player.sendMessage(" ");
											  player.sendMessage(ChatColor.YELLOW + "----[" + ChatColor.GREEN + " Item ID's Side 5 : " + ChatColor.YELLOW + "]----");
										  player.sendMessage("Stone Button ID = 77");
										  player.sendMessage("Ice ID = 79");
										  player.sendMessage("Snow ID = 80");
										  player.sendMessage("Cactus ID = 81");
										  player.sendMessage("Clay Block ID = 82");
										  player.sendMessage("Jukebox ID = 84");
										  player.sendMessage("Fence ID = 85");
										  player.sendMessage("Pumpkin ID = 86");
										  player.sendMessage("Neterrack ID = 87");
										  player.sendMessage("Soul Sand ID = 88");
										  player.sendMessage("Glowstone ID = 89");
										  player.sendMessage("Jack 'o' lantern ID = 91");
										  player.sendMessage("Cake ID = 92");
										  player.sendMessage("Redstone Repeater ID = 93");
										  player.sendMessage("Trapdoor ID = 96");
										  player.sendMessage(" ");
										  player.sendMessage(ChatColor.GOLD + "/gimeginfo 6 for neste side");
									  }
										  if (args[0].equalsIgnoreCase("6")){
											  player.sendMessage(" ");
											  player.sendMessage(ChatColor.YELLOW + "----[" + ChatColor.GREEN + " Item ID's Side 6 : " + ChatColor.YELLOW + "]----");
										  player.sendMessage("Stone Brick ID = 98");
										  player.sendMessage("Mushroom Block ID = 99, 100");
										  player.sendMessage("Iron Bars ID = 101");
										  player.sendMessage("Glass Pane ID = 102");
										  player.sendMessage("Melon ID = 103");
										  player.sendMessage("Vines ID = 106");
										  player.sendMessage("Fence Gate ID = 107");
										  player.sendMessage("Brick Stairs = 108");
										  player.sendMessage("Stone Brick Stairs ID = 109");
										  player.sendMessage("Mycelium ID = 110");
										  player.sendMessage("Lily Pad ID = 111");
										  player.sendMessage("Nether Brick ID = 112");
										  player.sendMessage("Nether Fence ID = 113");
										  player.sendMessage("Nether Stairs ID = 114");
										  player.sendMessage("Enchantment Table ID = 116");
										  player.sendMessage(" ");
										  player.sendMessage(ChatColor.GOLD + "/gimeginfo 7 for neste side");
									  }
										  if (args[0].equalsIgnoreCase("7")){
											  player.sendMessage(" ");
											  player.sendMessage(ChatColor.YELLOW + "----[" + ChatColor.GREEN + " Item ID's Side 7 : " + ChatColor.YELLOW + "]----");
										  player.sendMessage("Dragon Egg ID = 122");
										  player.sendMessage("Iron Shovel ID = 256");
										  player.sendMessage("Iron Pickaxe");
										  player.sendMessage("Iron Axe ID = 258");
										  player.sendMessage("Flint And Steel ID = 259");
										  player.sendMessage("Apple ID = 260");
										  player.sendMessage("Bow ID = 261");
										  player.sendMessage("Arrows ID = 262");
										  player.sendMessage("Coal ID = 263");
										  player.sendMessage("Charcoal ID = 263:1");
										  player.sendMessage("Diamond ID = 264");
										  player.sendMessage("Iron Ingot ID = 265");
										  player.sendMessage("Gold Ingot ID = 266");
										  player.sendMessage("Iron Sword ID = 267");
										  player.sendMessage("Wood Sword ID = 268");
										  player.sendMessage(" ");
										  player.sendMessage(ChatColor.GOLD + "/gimeginfo 8 for neste side");
									  }
										  if (args[0].equalsIgnoreCase("8")){
											  player.sendMessage(" ");
											  player.sendMessage(ChatColor.YELLOW + "----[" + ChatColor.GREEN + " Item ID's Side 8 : " + ChatColor.YELLOW + "]----");
										  player.sendMessage("Wooden Shovel ID = 269");
										  player.sendMessage("Wooden Pickaxe ID = 270");
										  player.sendMessage("Wooden Axe ID = 271");
										  player.sendMessage("Stone Sword ID = 272");
										  player.sendMessage("Stone Shovel ID = 273");
										  player.sendMessage("Stone Pickaxe ID = 274");
										  player.sendMessage("Stone Axe ID = 275");
										  player.sendMessage("Diamond Sword ID = 276");
										  player.sendMessage("Diamond Shovel ID = 278");
										  player.sendMessage("Diamond Pickaxe ID = 278");
										  player.sendMessage("Diamond Axe ID = 279");
										  player.sendMessage("Stick ID = 280");
										  player.sendMessage("Bowl ID = 281");
										  player.sendMessage("Mushroom Stew ID = 282");
										  player.sendMessage("Golden Sword ID 283");
										  player.sendMessage(" ");
										  player.sendMessage(ChatColor.GOLD + "/gimeginfo 9 for neste side");
									  }
										  if (args[0].equalsIgnoreCase("9")){
											  player.sendMessage(" ");
											  player.sendMessage(ChatColor.YELLOW + "----[" + ChatColor.GREEN + " Item ID's Side 9 : " + ChatColor.YELLOW + "]----");
										  player.sendMessage("Golden Shovel ID = 284");
										  player.sendMessage("Golden Pickaxe ID = 285");
										  player.sendMessage("Golden Axe ID = 286");
										  player.sendMessage("String ID = 287");
										  player.sendMessage("Feather ID = 288");
										  player.sendMessage("Gunpowder ID = 289");
										  player.sendMessage("Wooden Hoe ID = 290");
										  player.sendMessage("Stone Hoe ID = 291");
										  player.sendMessage("Iron Hoe ID = 292");
										  player.sendMessage("Diamond Hoe ID = 293");
										  player.sendMessage("Golden Hoe ID = 294");
										  player.sendMessage("Seeds ID = 295");
										  player.sendMessage("Wheat ID = 296");
										  player.sendMessage("Bread ID = 297");
										  player.sendMessage("Leather Hat ID = 298");
										  player.sendMessage(" ");
										  player.sendMessage(ChatColor.GOLD + "/gimeginfo 10 for neste side");
									  }
										  if (args[0].equalsIgnoreCase("10")){
											  player.sendMessage(" ");
											  player.sendMessage(ChatColor.YELLOW + "----[" + ChatColor.GREEN + " Item ID's Side 10 : " + ChatColor.YELLOW + "]----");
										  player.sendMessage("Leather Tunic ID = 299");
										  player.sendMessage("Leather Pants ID = 300");
										  player.sendMessage("Leather Boots ID = 301");
										  player.sendMessage("Chain Helmet ID = 302");
										  player.sendMessage("Chain Chestplate ID = 303");
										  player.sendMessage("Chain Leggings ID = 304");
										  player.sendMessage("Chain Boots ID = 305");
										  player.sendMessage("Iron Helmet ID = 306");
										  player.sendMessage("Iron Chestplate ID = 307");
										  player.sendMessage("Iron Leggings ID = 308");
										  player.sendMessage("Iron Boots ID = 309");
										  player.sendMessage("Diamond Helmet ID = 310");
										  player.sendMessage("Diamond Chestplate ID = 311");
										  player.sendMessage("Diamond Leggings ID = 312");
										  player.sendMessage("Diamond Boots ID = 313");
										  player.sendMessage(" ");
										  player.sendMessage(ChatColor.GOLD + "/gimeginfo 11 for neste side");
									  }
										  if (args[0].equalsIgnoreCase("11")){
											  player.sendMessage(" ");
											  player.sendMessage(ChatColor.YELLOW + "----[" + ChatColor.GREEN + " Item ID's Side 11 : " + ChatColor.YELLOW + "]----");
										  player.sendMessage("Golden Helmet ID = 314");
										  player.sendMessage("Golden Chestplate ID = 315");
										  player.sendMessage("Golden Leggings ID = 316");
										  player.sendMessage("Golden Boots ID = 317");
										  player.sendMessage("Flint ID = 318");
										  player.sendMessage("Raw Porkchop ID = 319");
										  player.sendMessage("Cooked Porkchop ID = 320");
										  player.sendMessage("Painting ID = 321");
										  player.sendMessage("Golden Apple ID = 322");
										  player.sendMessage("Sign ID = 323");
										  player.sendMessage("Wooden Door ID = 324");
										  player.sendMessage("Bucket ID = 325");
										  player.sendMessage("Water Bucket ID = 326");
										  player.sendMessage("Lava Bucket ID = 327");
										  player.sendMessage("Minecart ID = 328");
										  player.sendMessage(" ");
										  player.sendMessage(ChatColor.GOLD + "/gimeginfo 12 for neste side");
									  }
										  if (args[0].equalsIgnoreCase("12")){
											  player.sendMessage(" ");
											  player.sendMessage(ChatColor.YELLOW + "----[" + ChatColor.GREEN + " Item ID's Side 12 : " + ChatColor.YELLOW + "]----");
										  player.sendMessage("Saddle ID = 329");
										  player.sendMessage("Iron Door ID = 330");
										  player.sendMessage("Redstone ID = 331");
										  player.sendMessage("Snowball ID = 332");
										  player.sendMessage("Boat ID = 333");
										  player.sendMessage("Leather ID = 334");
										  player.sendMessage("Milk Bucket ID = 335");
										  player.sendMessage("Brick ID = 336");
										  player.sendMessage("Clay ID = 337");
										  player.sendMessage("Suger Canes ID = 338");
										  player.sendMessage("Paper ID = 339");
										  player.sendMessage("Book ID = 340");
										  player.sendMessage("SlimeBall ID = 341");
										  player.sendMessage("Minecart With Chest ID = 342");
										  player.sendMessage("Minecart With Furnace ID = 343");
										  player.sendMessage(" ");
										  player.sendMessage(ChatColor.GOLD + "/gimeginfo 13 for neste side");
									  }
										  if (args[0].equalsIgnoreCase("13")){
											  player.sendMessage(" ");
											  player.sendMessage(ChatColor.YELLOW + "----[" + ChatColor.GREEN + " Item ID's Side 13 : " + ChatColor.YELLOW + "]----");
										  player.sendMessage("Egg ID = 344");
										  player.sendMessage("Compass ID = 345");
										  player.sendMessage("Fishing Rod ID = 346");
										  player.sendMessage("Clock ID = 347");
										  player.sendMessage("Glowstone Dust ID = 348");
										  player.sendMessage("Raw Fish ID = 349");
										  player.sendMessage("Cooked Fish ID = 350");
										  player.sendMessage("Inc Sac ID = 351 /gimeginfo dye");
										  player.sendMessage("Bone ID = 352");
										  player.sendMessage("Sugar ID = 353");
										  player.sendMessage("Cake ID = 354");
										  player.sendMessage("Bed ID = 355");
										  player.sendMessage("Redstone Repeater ID = 356");
										  player.sendMessage("Cookie ID = 357");
										  player.sendMessage("Map ID = 358");
										  player.sendMessage(" ");
										  player.sendMessage(ChatColor.GOLD + "/gimeginfo 14 for neste side");
									  }
										  if (args[0].equalsIgnoreCase("14")){
											  player.sendMessage(" ");
											  player.sendMessage(ChatColor.YELLOW + "----[" + ChatColor.GREEN + " Item ID's Side 14 : " + ChatColor.YELLOW + "]----");
										  player.sendMessage("Shears ID = 359");
										  player.sendMessage("Melon ID = 360");
										  player.sendMessage("Pumpkin Seeds ID = 361");
										  player.sendMessage("Melon Seeds ID = 362");
										  player.sendMessage("Raw Beef ID = 363");
										  player.sendMessage("Steak ID = 364");
										  player.sendMessage("Raw Chicken ID = 365");
										  player.sendMessage("Cooked Chicken ID = 366");
										  player.sendMessage("Rotten Flesh ID = 367S");
										  player.sendMessage("Ender Pearl ID = 368");
										  player.sendMessage("Blaze Rod ID = 369");
										  player.sendMessage("Ghast Tear ID = 370");
										  player.sendMessage("Gold Nugget ID = 371");
										  player.sendMessage("Nether Wart ID = 372");
										  player.sendMessage("Water Bottle ID = 373");
										  player.sendMessage(" ");
										  player.sendMessage(ChatColor.GOLD + "/gimeginfo 15 for neste side");
									  }
										  if (args[0].equalsIgnoreCase("15")){
											  player.sendMessage(" ");
											  player.sendMessage(ChatColor.YELLOW + "----[" + ChatColor.GREEN + " Item ID's Side 15 : " + ChatColor.YELLOW + "]----");
										  player.sendMessage("Glass Bottle ID = 374");
										  player.sendMessage("Spider Eye ID = 375");
										  player.sendMessage("Fermented Spider Eye ID = 376");
										  player.sendMessage("Blaze Powder ID = 377");
										  player.sendMessage("Magma Cream ID = 378");
										  player.sendMessage("Brewing Stand ID = 379");
										  player.sendMessage("Cauldron ID = 380");
										  player.sendMessage("Eye Of Ender ID = 381");
										  player.sendMessage("Glistering Melon ID = 382");
										  player.sendMessage("Music Disc ID's = 2256 - 2266");
										  player.sendMessage(" ");
										  player.sendMessage(ChatColor.GOLD + "Dette var siste side !");
									  }
										  if (args[0].equalsIgnoreCase("dyes")){
											  player.sendMessage(" ");
											  player.sendMessage(ChatColor.YELLOW + "----[" + ChatColor.GREEN + " Dyes : " + ChatColor.YELLOW + "]----");
											  player.sendMessage("Rose Red ID = 351:1");
											  player.sendMessage("Cactus Green ID = 351:2");
											  player.sendMessage("Cocoa Beans ID = 351:3");
											  player.sendMessage("Lapis Lazuli ID = 351:4");
											  player.sendMessage("Purple Dye ID = 351:5");
											  player.sendMessage("Cyan Dye ID = 351:6");
											  player.sendMessage("Light Grey Dye ID = 351:7");
											  player.sendMessage("Gray Dye ID = 351:8");
											  player.sendMessage("Pink Dye ID = 351:9");
											  player.sendMessage("Lime Dye ID = 351:10");
											  player.sendMessage("Dandelion Dye ID = 351:11");
											  player.sendMessage("Light Blue Dye ID = 351:12");
											  player.sendMessage("Magenta Dye ID = 351:13");
											  player.sendMessage("Orange Dye ID = 351:14");
											  player.sendMessage("Bone Meal ID = 351:15");
											  player.sendMessage(" ");
											  player.sendMessage(ChatColor.GOLD + "/gimeginfo wool");
										   }
										  if (args[0].equalsIgnoreCase("wool")){
											  player.sendMessage(" ");
											  player.sendMessage(ChatColor.YELLOW + "----[" + ChatColor.GREEN + " Wool : " + ChatColor.YELLOW + "]----");
											  player.sendMessage("Wool ID = 35");
											  player.sendMessage("Orange Wool ID = 35:1");
											  player.sendMessage("Magenta Wool ID = 35:2");
											  player.sendMessage("Light Blue Wool ID = 34:3");
											  player.sendMessage("Yellow Wool ID = 35:4");
											  player.sendMessage("Lime Wool ID = 35:5");
											  player.sendMessage("Pink Wool ID = 35:6");
											  player.sendMessage("Gray Wool ID = 35:7");
											  player.sendMessage("Light Gray Wool ID = 35:8");
											  player.sendMessage("Cyan Wool ID = 35:9");
											  player.sendMessage("Purple Wool ID = 35:10");
											  player.sendMessage("Blue Wool ID = 35:11");
											  player.sendMessage("Brown Wool ID = 35:12");
											  player.sendMessage("Green Wool ID = 35:13");
											  player.sendMessage("Red Wool ID = 35:14");
											  player.sendMessage("Black Wool ID = 35:15");
											  player.sendMessage(" ");
											  player.sendMessage(ChatColor.GOLD + "Slutt");
										  }
									  }else if(commandlabel.equalsIgnoreCase("setspawn")){
										  Location spawn = player.getLocation();
										  player.getWorld().setSpawnLocation(spawn.getBlockX(), spawn.getBlockY(), spawn.getBlockZ());
										  player.sendMessage(ChatColor.AQUA + "Spawn er satt");
									  }else if(commandlabel.equalsIgnoreCase("spawn")){
										  Location spawn = player.getWorld().getSpawnLocation();
										  spawn.setX(spawn.getBlockX() + 0.5);
										  spawn.setY(spawn.getBlockY());
									      spawn.setZ(spawn.getBlockZ() + 0.5);
									      player.teleport(spawn);
									      player.sendMessage(ChatColor.AQUA + "Teleportert til Spawn");
										  
									  }
		
		return true;
								  }
private boolean hasPermission(String string) {
	// TODO Auto-generated method stub
	return false;
}

}