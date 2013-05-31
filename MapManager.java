package me.ItsDanniey1.Restock.GameLogic;

import me.ItsDanniey1.Restock.GameLogic.MapManager;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

public class MapManager {

	public static int map = 0;
	public static String worldList[] = { "Restock" };

	public static World getWorld() {
		switch (map) {
		case 0:
			return Bukkit.getServer().getWorld(worldList[0]);
		}
		return null;
	}

	public static double[][] getSpawns() {
		double spawns1[][] = {

				{ 11.5, 76, 3.5, 1, 90 },
				{ 10.5, 76, 7.5, 1, 110 },
				{ 8.5, 76, 11.5, 2, 135 },
				{ 4.5, 76, 13.5, 2, 155 },
				{ 0.5, 76, 14.5, 2, 180 },
				{ -4.5, 76, 13.5, 2, -156 },
				{ -8.5, 76, 11.5, 2, -136 },
				{ -10.5, 76, 7.5, 3, -110 },
				{ -11.5, 76, 3.5, 3, -90 },
				{ -10.5, 76, -1.5, 3, -65 },
				{ -8.5, 76, -5.5, 0, -45 },
				{ -4.5, 76, -7.5, 0, -20 },
				{ 0.5, 76, -8.5, 0, 0 },
				{ 4.5, 76, -7.5, 0, 20 },
				{ 8.5, 76, -5.5, 1, 45 },
				{ 10.5, 76, -1.5, 1, 6 },
				};

		switch (map) {
		case 0:
			return spawns1;

		}
		return null;
	}

	// Worse
	public static Location[] getWorseBlocks() {
		Location[] chests1 = {
				(MapManager.getWorld().getBlockAt(0, 74, 1).getLocation()),
				(MapManager.getWorld().getBlockAt(5, 74, -24).getLocation()),
				
				(MapManager.getWorld().getBlockAt(30, 76, -5).getLocation()),
				(MapManager.getWorld().getBlockAt(30, 79, 3).getLocation()),
				
				(MapManager.getWorld().getBlockAt(8, 76, 33).getLocation()),
				(MapManager.getWorld().getBlockAt(-8, 76, 33).getLocation()),
				
				(MapManager.getWorld().getBlockAt(-24, 77, -21).getLocation()),
				(MapManager.getWorld().getBlockAt(-23, 75, 3).getLocation()),
				
		};


		switch (map) {
		case 0:
			return chests1;
		}
			return null;
		}

	// Orate
	public static Location[] getOrateBlocks() {
		Location[] chests1 = {
				(MapManager.getWorld().getBlockAt(0, 75, -20).getLocation()),
				(MapManager.getWorld().getBlockAt(0, 79, -27).getLocation()),
				
				(MapManager.getWorld().getBlockAt(27, 74, 8).getLocation()),
				(MapManager.getWorld().getBlockAt(24, 77, 27).getLocation()),
				
				(MapManager.getWorld().getBlockAt(0, 79, 33).getLocation()),
				(MapManager.getWorld().getBlockAt(5, 74, 30).getLocation()),

				(MapManager.getWorld().getBlockAt(-37, 74, -2).getLocation()),
				(MapManager.getWorld().getBlockAt(-2, 74, 3).getLocation()),

				};

		switch (map) {
		case 0:
			return chests1;
		}
			return null;
		}

	//Medium
	public static Location[] getMediumBlocks() {
		Location[] chests1 = {
				(MapManager.getWorld().getBlockAt(24, 77, -21).getLocation()),
				(MapManager.getWorld().getBlockAt(8, 76, -27).getLocation()),
				
				(MapManager.getWorld().getBlockAt(23, 75, 3).getLocation()),
				(MapManager.getWorld().getBlockAt(27, 74, -2).getLocation()),
				
				(MapManager.getWorld().getBlockAt(0, 75, 26).getLocation()),
				(MapManager.getWorld().getBlockAt(0, 74, 5).getLocation()),

				(MapManager.getWorld().getBlockAt(-27, 74, 8).getLocation()),
				(MapManager.getWorld().getBlockAt(-30, 76, 11).getLocation()),




				};

		switch (map) {
		case 0:
			return chests1;
		}
			return null;
		}
	
	//Better
	public static Location[] getBetterBlock() {
		Location[] chests1 = {
				(MapManager.getWorld().getBlockAt(-8, 76, -27).getLocation()),	
				
				(MapManager.getWorld().getBlockAt(30, 76, 11).getLocation()),
				
				(MapManager.getWorld().getBlockAt(-5, 74, 30).getLocation()),
				
				(MapManager.getWorld().getBlockAt(-30, 76, -5).getLocation()),



		};

		switch (map) {
		case 0:
			return chests1;
		}
			return null;
		}

	//Best
	public static Location[] getBestBlocks() {
		Location[] chests1 = {
				(MapManager.getWorld().getBlockAt(0, 83, 3).getLocation()),				
		};

		switch (map) {
		case 0:
			return chests1;
		}
			return null;
		}
	
	//Bow
	public static Location[] getBowBlocks() {
		Location[] chests1 = {
				(MapManager.getWorld().getBlockAt(-5, 74, -24).getLocation()),		
				
				(MapManager.getWorld().getBlockAt(2, 74, 3).getLocation()),

				(MapManager.getWorld().getBlockAt(-24, 77, 27).getLocation()),

				(MapManager.getWorld().getBlockAt(-30, 79, 3).getLocation()),

		};

		switch (map) {
		case 0:
			return chests1;
		}
			return null;
		}
}
