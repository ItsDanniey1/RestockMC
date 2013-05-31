package me.ItsDanniey1.Restock.GameLogic;

import java.util.HashMap;

import me.ItsDanniey1.Restock.RSPlayer;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Cache {
	
	public static HashMap<String, Integer> usedSpawns = new HashMap<>();
	public static HashMap<Player, String> AlivePlayers = new HashMap<Player, String>();
	public static HashMap<Player, String> DeadPlayers = new HashMap<Player, String>();
	public static HashMap<String, RSPlayer> RSPlayers = new HashMap<String, RSPlayer>();



	
	public static HashMap<Integer, ItemStack> Items = new HashMap<Integer, ItemStack>();

	
	public static void clearAll() {
		usedSpawns.clear();
		AlivePlayers.clear();
		DeadPlayers.clear();
		RSPlayers.clear();

		
	}

}
