package me.ItsDanniey1.Restock.GameLogic;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Utils {
	
	public static void broadcast(String msg) {
		Bukkit.getServer().broadcastMessage(ChatColor.RED+"[Restock] "+ChatColor.WHITE+msg);
	}
	
	public static void msg(Player player, String msg) {
		player.sendMessage(ChatColor.RED+"[Restock] "+ChatColor.WHITE+msg);
	}
	
	public static void debug( String msg) {
		Bukkit.getServer().broadcastMessage(ChatColor.DARK_RED+"[DEBUG] "+ChatColor.YELLOW+msg);
	}

}
