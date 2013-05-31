package me.ItsDanniey1.Restock;

import java.util.ArrayList;
import java.util.Random;

import me.ItsDanniey1.Restock.GameLogic.Cache;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.inventory.meta.ItemMeta;

import daneffectapi.DanEffectAPI;
import daneffectapi.Particles;

public class Items implements Listener {

	public static Restock plugin;
	
	private Random rand = new Random();
	
	

	// Items

	public static ItemStack getWorseSword() {
		ItemStack worse = new ItemStack(Material.WOOD_SWORD, 1);
		worse.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
		ItemMeta im = worse.getItemMeta();
		im.setDisplayName(ChatColor.GREEN + "Weak Sword");
		worse.setItemMeta(im);
		Cache.Items.put(1, worse);
		return worse;
	}

	public static ItemStack getOrateSword() {
		ItemStack orate = new ItemStack(Material.WOOD_SWORD, 1);
		orate.addEnchantment(Enchantment.KNOCKBACK, 1);
		orate.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
		ItemMeta im = orate.getItemMeta();
		im.setDisplayName(ChatColor.GREEN + "Pointy Sword");
		orate.setItemMeta(im);
		Cache.Items.put(2, orate);

		return orate;
	}

	public static ItemStack getBow() {
		ItemStack bow = new ItemStack(Material.BOW, 1);
		bow.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
		ItemMeta im = bow.getItemMeta();
		im.setDisplayName(ChatColor.GREEN + "Arched Bow");
		bow.setItemMeta(im);
		Cache.Items.put(3, bow);

		return bow;
	}

	public static ItemStack getMediumSword() {
		ItemStack medium = new ItemStack(Material.STONE_SWORD, 1);
		medium.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
		ItemMeta im = medium.getItemMeta();
		im.setDisplayName(ChatColor.GREEN + "Good Sword");
		medium.setItemMeta(im);
		Cache.Items.put(4, medium);

		return medium;
	}

	public static ItemStack getBetterSword() {
		ItemStack better = new ItemStack(Material.STONE_SWORD, 1);
		better.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
		better.addEnchantment(Enchantment.FIRE_ASPECT, 1);
		ItemMeta im = better.getItemMeta();
		im.setDisplayName(ChatColor.GREEN + "Dangerous Sword");
		better.setItemMeta(im);
		Cache.Items.put(5, better);

		return better;
	}

	public static ItemStack getBestSword() {
		ItemStack best = new ItemStack(Material.IRON_SWORD, 1);
		best.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
		ItemMeta im = best.getItemMeta();
		im.setDisplayName(ChatColor.GREEN + "Deadly Sword");
		best.setItemMeta(im);
		Cache.Items.put(6, best);

		return best;
	}

	public static ItemStack getBook() {
		ItemStack is = new ItemStack(Material.WRITTEN_BOOK, 1);
		is.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
		BookMeta bm = (BookMeta) is.getItemMeta();
		bm.setAuthor("the Creators");
		bm.setTitle(ChatColor.GREEN + "RESTOCK!");
		ArrayList<String> pages = new ArrayList<String>();
		pages.add(ChatColor.DARK_PURPLE + "Restock" + ChatColor.BLUE
				+ " is a custom server gametype created by Danniey1 and " + ChatColor.RED + "DCDJ!"
				+ ChatColor.GREEN + "\n\n\n\nRestock" + ChatColor.BLUE
				+ " A game of luck and skill!");
		pages.add(ChatColor.BLUE
				+ "The way to win "
				+ ChatColor.DARK_PURPLE
				+ "Restock "
				+ ChatColor.BLUE
				+ "is by being the last player alive. \n\nThe best way to win is by running over the"
				+ ChatColor.GREEN + " EMERALD BLOCKS" + ChatColor.BLUE
				+ " on the floor, and they will give you a weapon!");
		pages.add(ChatColor.GOLD.toString()
				+ ChatColor.BOLD.toString()
				+ "The Game!"
				+ ChatColor.BLUE
				+ "\n\nOnce the game has started, you should aim to run over an emerald block, which gives you an item! \n\nAfter 45 seconds, the EMERALD BLOCKS will be activated again, allowing you to run over them once more!");
				pages.add(
				ChatColor.RED
				+ "\n\n Be careful though, as running over an emerald block makes you lose whatever you had, so let's hope you're lucky!");

		bm.setPages(pages);
		is.setItemMeta(bm);
		return is;
	}
}
