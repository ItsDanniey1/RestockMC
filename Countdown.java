package me.ItsDanniey1.Restock.GameLogic;

import me.ItsDanniey1.Restock.EndCount;
import me.ItsDanniey1.Restock.Restock;

import me.ItsDanniey1.Restock.GameLogic.GameState;
import me.ItsDanniey1.Restock.GameLogic.StateManager;
import me.ItsDanniey1.Restock.GameLogic.Utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

public class Countdown implements Runnable {

	public static Restock plugin;

	private static int taskID;
	private int tick = 0;

	@Override
	public void run() {

		if (tick == 0) {
			Restock.prepGame();

			GameManager.cancelTask();
		}

		if (tick <= 9) {
			Utils.broadcast(ChatColor.YELLOW + "Game starting in "
					+ ChatColor.GREEN + (10 - tick) + " seconds");
		}

		if (tick == 10) {
			StateManager.setState(GameState.IN_PROGRESS);
			Restock.startGame();
			Utils.broadcast(ChatColor.GREEN + "Game has STARTED!");
		}

		if (tick == 55) {
			Restock.resetEmerald();
			Utils.broadcast(ChatColor.GOLD + "RESTOCKING!");
		}
		if (tick == 100) {
			Restock.resetEmerald();
			Utils.broadcast(ChatColor.GOLD + "RESTOCKING!");
		}
		if (tick == 145) {
			Restock.resetEmerald();
			Utils.broadcast(ChatColor.GOLD + "RESTOCKING!");
		}

		if (tick == 190) {
			Restock.resetEmerald();
			Utils.broadcast(ChatColor.GOLD + "RESTOCKING!");
		}

		if (tick == 235) {
			Restock.resetEmerald();
			Utils.broadcast(ChatColor.GOLD + "RESTOCKING!");
		}
		if (tick == 280) {
			Restock.resetEmerald();
			Utils.broadcast(ChatColor.GOLD + "RESTOCKING!");
		}

		if (tick == 190) {
			Utils.broadcast(ChatColor.YELLOW + "GAME ENDING IN "
					+ ChatColor.GREEN + " 2 minutes!");
		}

		if (tick == 250) {
			Utils.broadcast(ChatColor.YELLOW + "GAME ENDING IN "
					+ ChatColor.GREEN + " 1 minute!");
		}

		if (tick == 300) {
			Utils.broadcast(ChatColor.YELLOW + "GAME ENDING IN "
					+ ChatColor.YELLOW + " 10 seconds!");
		}

		if (tick == 305) {
			Utils.broadcast(ChatColor.YELLOW + "GAME ENDING IN "
					+ ChatColor.RED + " 5 seconds!");
		}

		if (tick == 310) {
			//Restock.finishGame();
			
			EndCount cd = new EndCount();
			cd.setTaskID(Bukkit.getServer().getScheduler()
					.scheduleSyncRepeatingTask(Restock.plugin, cd, 0L, 20L));
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
