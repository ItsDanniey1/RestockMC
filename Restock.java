package me.ItsDanniey1.Restock;

import java.sql.Time;

import me.ItsDanniey1.Restock.RSPlayer;
import me.ItsDanniey1.Restock.GameLogic.Countdown;
import me.ItsDanniey1.Restock.GameLogic.GameManager;
import me.ItsDanniey1.Restock.GameLogic.GameState;
import me.ItsDanniey1.Restock.GameLogic.PlayerMovement;
import me.ItsDanniey1.Restock.GameLogic.StateManager;
import me.ItsDanniey1.Restock.GameLogic.Cache;
import me.ItsDanniey1.Restock.GameLogic.MapManager;
import me.ItsDanniey1.Restock.Restock;
import me.ItsDanniey1.Restock.GameLogic.PlayerInteractEvents;
import me.ItsDanniey1.Restock.GameLogic.Utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.plugin.java.JavaPlugin;

import daneffectapi.DanEffectAPI;
import daneffectapi.Particles;

public class Restock extends JavaPlugin implements Listener {

	public static Restock plugin;

	@Override
	public void onDisable() {
		Bukkit.broadcastMessage(ChatColor.GOLD + "Restock by ItsDanniey1 -"
				+ ChatColor.BOLD + ChatColor.DARK_BLUE + "DISABLED!");
		Bukkit.broadcastMessage(ChatColor.GREEN + "- - - - - - - - - - - - - -");
		Bukkit.broadcastMessage(ChatColor.DARK_RED + "Version 0.1!");
		Bukkit.broadcastMessage(ChatColor.GREEN + "- - - - - - - - - - - - - -");

	}

	@Override
	public void onEnable() {
		Bukkit.broadcastMessage(ChatColor.GOLD + "Restock by ItsDanniey1 -"
				+ ChatColor.BOLD + ChatColor.AQUA + "ENABLED!");
		Bukkit.broadcastMessage(ChatColor.GREEN + "- - - - - - - - - - - - - -");
		Bukkit.broadcastMessage(ChatColor.DARK_RED + "Version 0.1!");
		Bukkit.broadcastMessage(ChatColor.GREEN + "- - - - - - - - - - - - - -");

		StateManager.setState(GameState.WAITING);

		System.out.println("Registering listeners...");
		Bukkit.getServer().getPluginManager().registerEvents(this, this);
		Bukkit.getServer().getPluginManager()
				.registerEvents(new PlayerMovement(), this);
		Bukkit.getServer().getPluginManager()
				.registerEvents(new PlayerInteractEvents(), this);

		System.out.println("DONE!");

		GameManager gm = new GameManager();
		gm.setTaskID(Bukkit.getServer().getScheduler()
				.scheduleSyncRepeatingTask(this, gm, 0L, 20L));

		MapManager.getWorld().setAutoSave(false);

		plugin = this;

		MapManager.getWorld().setMonsterSpawnLimit(0);
		for (Player player : Bukkit.getOnlinePlayers()) {
			World world = MapManager.getWorld();
			world.playSound(player.getLocation(), Sound.AMBIENCE_THUNDER, 1, 1);
			Location lobbyspawn = new Location(world, 0.5, 105.5, 0.5, 0, 0);
			world.setSpawnLocation(0, 105, 0);

			player.teleport(lobbyspawn);
			Inventory inv = player.getInventory();
			inv.clear();
			inv.addItem(Items.getBook());
			player.setGameMode(GameMode.ADVENTURE);
			((PlayerInventory) inv).setArmorContents(null);
			player.setHealth(20);
			player.setFoodLevel(20);

		}
		MapManager.getWorld().setAutoSave(false);

		plugin = this;

	}

	public void disconnect(PlayerQuitEvent event) {
		Player player = event.getPlayer();

		Inventory inv = player.getInventory();

		inv.clear();
		
		if(Cache.AlivePlayers.containsKey(player)) {
			Cache.AlivePlayers.remove(player);
				
			}
			
		
		if(Cache.RSPlayers.containsKey(player)) {
			Cache.RSPlayers.remove(player);
			
		}

	}

	@EventHandler
	public void playerDrops(PlayerDeathEvent e) {
		e.getDrops().clear();
	}
	
	@EventHandler
	public void playerThrow(PlayerDropItemEvent e) {
		
		e.setCancelled(true);
		
	}
	@EventHandler
	public void playerDamage(EntityDamageByEntityEvent event) {
		if (event.getEntity() instanceof Player) {
			if (event.getDamager() instanceof Player) {

				if (StateManager.getState() == GameState.IN_PROGRESS) {

					Player hit = (Player) event.getEntity();

					Location loc = hit.getLocation();

					World world = hit.getWorld();

					int X = loc.getBlockX();
					int Y = loc.getBlockY() + 1;
					int Z = loc.getBlockZ();

					Location loc1 = new Location(world, X, Y, Z);

					DanEffectAPI.playEffect(loc1, Particles.LAVA_DRIP, 5F, 50);


				}
			}
		}
	}
	
	@EventHandler
	public void weatherChange(WeatherChangeEvent event) {
		World world = MapManager.getWorld();
		event.setCancelled(true);
		
	}

	//public static void timeNight() {
	//	World world = MapManager.getWorld();
		
		//if(world.getTime() == world.getTime()) {
		//	world.setTime(13000);
		//}
	//}
	

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		World world = Bukkit.getServer().getWorld(MapManager.worldList[0]);
		Location lobbyspawn = new Location(world, 0.5, 105.5, 0.5, 0, 0);
		world.setSpawnLocation(0, 105, 0);
		player.teleport(lobbyspawn);
		Inventory inv = player.getInventory();
		inv.clear();
		inv.addItem(Items.getBook());
		((PlayerInventory) inv).setArmorContents(null);
		player.setGameMode(GameMode.ADVENTURE);

		DanEffectAPI.playEffect(player.getLocation(), Particles.SLIME, 1F, 10);
		world.playSound(player.getLocation(), Sound.CHICKEN_EGG_POP, 1F, 1);


	}

	public boolean onCommand(CommandSender sender, Command cmd,
			String commandLabel, String[] args) {
		Player player = (Player) sender;

		if (commandLabel.equalsIgnoreCase("mobs")) {

			for (Entity e : player.getWorld().getEntities()) {

				if (e instanceof Player) {
					continue;
				}
				e.remove();
			}

			Bukkit.broadcastMessage("Entities removed");
		}

		if (commandLabel.equalsIgnoreCase("day")) {

			World world = player.getWorld();
			world.setTime(1);
		}

		if (commandLabel.equalsIgnoreCase("heal")) {

			player.setHealth(20);
			player.setFoodLevel(20);
		}
		// if (commandLabel.equalsIgnoreCase("map")) {
		// int map = Integer.parseInt(args[0]);
		// MapManager.map = map;
		// Utils.msg(player, ChatColor.GOLD + "Map changed!");
		// }

		if (commandLabel.equalsIgnoreCase("reset")) {

			resetEmerald();

		}

		if (commandLabel.equalsIgnoreCase("warmup")) {

			prepGame();

		}

		if (commandLabel.equalsIgnoreCase("halt")) {

			GameManager.cancelTask();

			Utils.broadcast(ChatColor.RED + "GameManager STOPPED!");

		}

		if (commandLabel.equalsIgnoreCase("startcountdown")) {

			GameManager gm = new GameManager();
			gm.setTaskID(Bukkit.getServer().getScheduler()
					.scheduleSyncRepeatingTask(this, gm, 0L, 20L));

			Utils.broadcast(ChatColor.GREEN + "GameManager STARTED!");

		}

		if (commandLabel.equalsIgnoreCase("start")) {
			Countdown cd = new Countdown();
			cd.setTaskID(Bukkit.getServer().getScheduler()
					.scheduleSyncRepeatingTask(this, cd, 0L, 20L));

			GameManager.cancelTask();
		}

		if (commandLabel.equalsIgnoreCase("finish")) {

			EndCount ec = new EndCount();
			ec.setTaskID(Bukkit.getServer().getScheduler()
					.scheduleSyncRepeatingTask(this, ec, 0L, 20L));

		}
		return false;
	}

	@EventHandler
	public void death2(PlayerDeathEvent e) {

		e.setDeathMessage(ChatColor.DARK_RED + e.getEntity().getName()
				+ ChatColor.GOLD + " has DIED!");
		Cache.DeadPlayers.put(e.getEntity(), e.getEntity().getName());
		Cache.AlivePlayers.remove(e.getEntity());
		e.getDrops().clear();
		Player player = (Player) e.getEntity();
		RSPlayer feplayer = Cache.RSPlayers.get(player.getName());
		feplayer.addDeath();
		if (player.getKiller() != null && player.getKiller() instanceof Player) {
			RSPlayer killer = Cache.RSPlayers.get(player.getKiller().getName());
			killer.addKill();
			Utils.msg(player.getKiller(), ChatColor.YELLOW + "You now have "
					+ killer.getKills() + " kills!");
			killer.save();

			feplayer.save();
			

					

		}
		
			
		if (Cache.AlivePlayers.size() == 1) {

			//finishGame();
			
			EndCount ec = new EndCount();
				ec.setTaskID(Bukkit.getServer().getScheduler()
						.scheduleSyncRepeatingTask(this, ec, 0L, 20L));
			}

		}

	

	public static void teleportPlayers(boolean debug) {
		int i = 0;
		for (Player player : Bukkit.getServer().getOnlinePlayers()) {
			if (player == null || player.isDead())
				continue;
			Location location = new Location(MapManager.getWorld(),
					MapManager.getSpawns()[i][0], MapManager.getSpawns()[i][1],
					MapManager.getSpawns()[i][2],
					(float) MapManager.getSpawns()[i][3], (float) 0);
			player.teleport(location);
			Cache.usedSpawns.put(player.getName(), i);
			if (debug)
				Utils.broadcast("Player " + player.getName()
						+ " teleported to spawn: " + i);
			i++;
		}
	}

	@EventHandler
	public void playerHunger(PlayerMoveEvent e) {

		Player player = e.getPlayer();
		player.setFoodLevel(20);
	}

	@EventHandler
	public void breakBlock(BlockBreakEvent event) {
		if (event.getPlayer().getGameMode() == GameMode.CREATIVE) {
			return;
		} else if (!event.getPlayer().isOp()) {
			event.setCancelled(true);
		}
	}

	public static void startGame() {

		for (Player players : Bukkit.getServer().getOnlinePlayers()) {

			RSPlayer feplayer = new RSPlayer(players.getName());
			Cache.RSPlayers.put(feplayer.getName(), feplayer);

			Cache.AlivePlayers.put(players, players.getName());

			players.setHealth(20);
			players.setFoodLevel(20);

			StateManager.setState(GameState.IN_PROGRESS);

		}

		resetEmerald();

	}

	public static void resetEmerald() {

		// WORSE
		for (Location loc : MapManager.getWorseBlocks()) {

			Block chest = MapManager.getWorld().getBlockAt(loc);

			if (chest.getType() == Material.REDSTONE_LAMP_OFF) {
				chest.setType(Material.EMERALD_BLOCK);
			}
		}
		// ORATE
		for (Location loc : MapManager.getOrateBlocks()) {

			Block chest = MapManager.getWorld().getBlockAt(loc);

			if (chest.getType() == Material.REDSTONE_LAMP_OFF) {
				chest.setType(Material.EMERALD_BLOCK);
			}
		}
		// MEDIUM
		for (Location loc : MapManager.getMediumBlocks()) {

			Block chest = MapManager.getWorld().getBlockAt(loc);

			if (chest.getType() == Material.REDSTONE_LAMP_OFF) {
				chest.setType(Material.EMERALD_BLOCK);
			}
		}
		// BETTER
		for (Location loc : MapManager.getBetterBlock()) {

			Block chest = MapManager.getWorld().getBlockAt(loc);

			if (chest.getType() == Material.REDSTONE_LAMP_OFF) {
				chest.setType(Material.EMERALD_BLOCK);
			}
		}
		// BEST
		for (Location loc : MapManager.getBestBlocks()) {

			Block chest = MapManager.getWorld().getBlockAt(loc);

			if (chest.getType() == Material.REDSTONE_LAMP_OFF) {
				chest.setType(Material.EMERALD_BLOCK);
			}
		}
		// BOW
		for (Location loc : MapManager.getBowBlocks()) {

			Block chest = MapManager.getWorld().getBlockAt(loc);

			if (chest.getType() == Material.REDSTONE_LAMP_OFF) {
				chest.setType(Material.EMERALD_BLOCK);
			}
		}

	}

	public static void prepGame() {

		for (Player player : Bukkit.getServer().getOnlinePlayers()) {

			// Inventory Management

			Inventory inventory = player.getInventory();
			inventory.clear();
			player.setGameMode(GameMode.ADVENTURE);

			player.setHealth(20);
			player.setFoodLevel(20);
			for (Entity e : player.getWorld().getEntities()) {

				if (e instanceof Player) {
					continue;
				}
				e.remove();
			}
		}

		teleportPlayers(true);
		StateManager.setState(GameState.WARMUP);
		
		resetEmerald();
		

	}

	public static void finishGame() {

		for (Player players : Bukkit.getServer().getOnlinePlayers()) {

			players.setGameMode(GameMode.ADVENTURE);
			Inventory inventory = players.getInventory();
			World world = MapManager.getWorld();
			Location lobbyspawn = new Location(world, 0, 105, 0, 0, 0);
			inventory.clear();
			players.teleport(lobbyspawn);
			Cache.DeadPlayers.clear();
			((PlayerInventory) inventory).setArmorContents(null);
			String p = Cache.AlivePlayers.get(players);

			if (p != null && !p.isEmpty()) {
				Utils.broadcast(ChatColor.GOLD

				+ p + ChatColor.YELLOW + " has won the game!");

				for (RSPlayer feplayer : Cache.RSPlayers.values()) {
					Utils.broadcast(ChatColor.GOLD + feplayer.getName()
							+ ChatColor.LIGHT_PURPLE + " scored "
							+ ChatColor.RED + feplayer.getKills()
							+ ChatColor.LIGHT_PURPLE + " kills and "
							+ ChatColor.RED + feplayer.getDeaths()
							+ ChatColor.LIGHT_PURPLE + " deaths!");

				}
			}
		

		MapManager.map = 0;

		GameManager gm = new GameManager();
		gm.setTaskID(Bukkit.getServer().getScheduler()
				.scheduleSyncRepeatingTask(Restock.plugin, gm, 0L, 20L));

		Cache.clearAll();

		StateManager.setState(GameState.ENDED);

		StateManager.setState(GameState.WAITING);

		Countdown.cancelTask();
		
		}

	}

}
