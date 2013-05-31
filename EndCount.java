package me.ItsDanniey1.Restock;

import me.ItsDanniey1.Restock.Restock;
import me.ItsDanniey1.Restock.GameLogic.Cache;
import me.ItsDanniey1.Restock.GameLogic.Countdown;
import me.ItsDanniey1.Restock.GameLogic.GameManager;
import me.ItsDanniey1.Restock.GameLogic.GameState;
import me.ItsDanniey1.Restock.GameLogic.MapManager;
import me.ItsDanniey1.Restock.GameLogic.StateManager;
import me.ItsDanniey1.Restock.RSPlayer;
import me.ItsDanniey1.Restock.GameLogic.Utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.PlayerInventory;

import daneffectapi.DanEffectAPI;
import daneffectapi.Particles;

public class EndCount implements Runnable {

	public static Restock plugin;

	private static int taskID;
	private int tick = 0;

	@Override
	public void run() {

		if (tick == 1) {
			Utils.broadcast(ChatColor.GREEN + "GAME ENDED!");
			Utils.broadcast(ChatColor.GOLD + "Returning to lobby in 10 seconds!");

			for (Player players : Bukkit.getServer().getOnlinePlayers()) {
				Inventory inv = players.getInventory();

				inv.clear();
				StateManager.setState(GameState.ENDED);
				players.setGameMode(GameMode.ADVENTURE);
				players.setHealth(20);
				players.setFoodLevel(20);

				Countdown.cancelTask();

				Location loc = players.getLocation();

				DanEffectAPI.playEffect(loc, Particles.LARGE_EXPLOSION, 2F, 15);

				World world = players.getWorld();

				world.playSound(loc, Sound.NOTE_PIANO, 1F, 1F);
			}
		}

		if (tick == 2) {
			for (Player players : Bukkit.getServer().getOnlinePlayers()) {
				String p = Cache.AlivePlayers.get(players);

				World world = players.getWorld();

				Location loc = players.getLocation();

				world.playSound(loc, Sound.NOTE_PIANO, 1F, 1F);

				if (p != null && !p.isEmpty()) {

					Utils.broadcast(ChatColor.GREEN
							+ "-------------------------");

					Utils.broadcast(ChatColor.GOLD

					+ p + ChatColor.YELLOW + " has won the game!");

					Utils.broadcast(ChatColor.GREEN
							+ "-------------------------");

					for (RSPlayer feplayer : Cache.RSPlayers.values()) {
						Utils.broadcast(ChatColor.GOLD + feplayer.getName()
								+ ChatColor.LIGHT_PURPLE + " scored "
								+ ChatColor.RED + feplayer.getKills()
								+ ChatColor.LIGHT_PURPLE + " kills and "
								+ ChatColor.RED + feplayer.getDeaths()
								+ ChatColor.LIGHT_PURPLE + " deaths!");

					}
				}
			}
		}

		if (tick == 3) {
			for (Player players : Bukkit.getServer().getOnlinePlayers()) {
				World world = players.getWorld();

				Location loc = players.getLocation();

				world.playSound(loc, Sound.NOTE_PIANO, 1F, 1F);

			}
		}

		if (tick == 4) {
			for (Player players : Bukkit.getServer().getOnlinePlayers()) {
				World world = players.getWorld();
				Location loc = players.getLocation();

				world.playSound(loc, Sound.NOTE_PIANO, 1F, 1F);

			}
		}
		
		if (tick == 5) {
			for (Player players : Bukkit.getServer().getOnlinePlayers()) {
				World world = players.getWorld();
				Location loc = players.getLocation();

				world.playSound(loc, Sound.NOTE_PIANO, 1F, 1F);

			}
		}
		
		if (tick == 6) {
			for (Player players : Bukkit.getServer().getOnlinePlayers()) {
				World world = players.getWorld();
				Location loc = players.getLocation();

				world.playSound(loc, Sound.NOTE_PIANO, 1F, 1F);

			}
		}
		
		if (tick == 7) {
			for (Player players : Bukkit.getServer().getOnlinePlayers()) {
				World world = players.getWorld();
				Location loc = players.getLocation();

				world.playSound(loc, Sound.NOTE_PIANO, 1F, 1F);

			}
		}
		
		if (tick == 8) {
			for (Player players : Bukkit.getServer().getOnlinePlayers()) {
				World world = players.getWorld();
				Location loc = players.getLocation();

				world.playSound(loc, Sound.NOTE_PIANO, 1F, 1F);

			}
		}

		if (tick == 9) {
			for (Player players : Bukkit.getServer().getOnlinePlayers()) {

				players.setGameMode(GameMode.ADVENTURE);
				Inventory inventory = players.getInventory();
				World world = MapManager.getWorld();
				Location lobbyspawn = new Location(world, 0, 104, 0, 0, 0);
				inventory.clear();
				players.teleport(lobbyspawn);
				Cache.DeadPlayers.clear();
				((PlayerInventory) inventory).setArmorContents(null);
				
				inventory.addItem(Items.getBook());

				World world1 = players.getWorld();

				Location loc = players.getLocation();

				world1.playSound(loc, Sound.NOTE_PIANO, 1F, 1F);
				
			}

			Utils.broadcast(ChatColor.GREEN + "Returning to lobby mode!");

			StateManager.setState(GameState.WAITING);

			GameManager gm = new GameManager();
			gm.setTaskID(Bukkit.getServer().getScheduler()
					.scheduleSyncRepeatingTask(Restock.plugin, gm, 0L, 20L));
		}

		if (tick == 10) {
			
			cancelTask();

		}

		tick++;

	}

	public void setTaskID(int i) {
		this.taskID = i;
	}

	public static void cancelTask() {
		Bukkit.getServer().getScheduler().cancelTask(taskID);
	}

}
