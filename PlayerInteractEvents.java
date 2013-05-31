package me.ItsDanniey1.Restock.GameLogic;

import me.ItsDanniey1.Restock.Items;
import me.ItsDanniey1.Restock.Restock;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.kitteh.tag.PlayerReceiveNameTagEvent;
import org.kitteh.tag.*;
import org.kitteh.tag.api.*;

import daneffectapi.DanEffectAPI;
import daneffectapi.Particles;

public class PlayerInteractEvents implements Listener {

	public static Restock plugin;
	

	@EventHandler
	public void playerMove(PlayerMoveEvent event) {

		Player player = event.getPlayer();

		Block block = player.getLocation().getBlock()
				.getRelative(BlockFace.DOWN);

		Inventory inv = player.getInventory();
		Location location = player.getLocation();
		World world = player.getWorld();
		
		// worst
		
		for (Location loc : MapManager.getWorseBlocks()) {
			if (block.getLocation().equals(loc)) {

				if (block.getType() == Material.EMERALD_BLOCK) {

					inv.clear();

					inv.addItem(Items.getWorseSword());

					block.setType(Material.REDSTONE_LAMP_OFF);

					Utils.msg(player, ChatColor.GREEN + "RESTOCKED!");
					
					DanEffectAPI.playEffect(location, Particles.LARGE_SMOKE, 1F, 10);
					
					
					
					world.playSound(location, Sound.CHICKEN_EGG_POP, 1F, 1F);
				}

			}
		}
		// orate
		for (Location loc : MapManager.getOrateBlocks()) {
			// if (block.equals(loc)) {
			if (block.getLocation().equals(loc)) {

				if (block.getType() == Material.EMERALD_BLOCK) {

					inv.clear();

					inv.addItem(Items.getOrateSword());

					block.setType(Material.REDSTONE_LAMP_OFF);

					Utils.msg(player, ChatColor.GREEN + "RESTOCKED!");
					
					DanEffectAPI.playEffect(location, Particles.LARGE_SMOKE, 1F, 10);
					
					world.playSound(location, Sound.CHICKEN_EGG_POP, 1F, 1F);
				}

			}
		}

		// medium
		for (Location loc : MapManager.getMediumBlocks()) {
			if (block.getLocation().equals(loc)) {

				if (block.getType() == Material.EMERALD_BLOCK) {

					inv.clear();

					inv.addItem(Items.getMediumSword());

					block.setType(Material.REDSTONE_LAMP_OFF);

					Utils.msg(player, ChatColor.GREEN + "RESTOCKED!");
					
					DanEffectAPI.playEffect(location, Particles.LARGE_SMOKE, 1F, 10);
					
					world.playSound(location, Sound.CHICKEN_EGG_POP, 1F, 1F);
				}

			}
		}

		// better
		for (Location loc : MapManager.getBetterBlock()) {
			if (block.getLocation().equals(loc)) {

				if (block.getType() == Material.EMERALD_BLOCK) {

					inv.clear();

					inv.addItem(Items.getBetterSword());

					block.setType(Material.REDSTONE_LAMP_OFF);

					Utils.msg(player, ChatColor.GREEN + "RESTOCKED!");
					
					DanEffectAPI.playEffect(location, Particles.LARGE_SMOKE, 1F, 10);
					
					world.playSound(location, Sound.CHICKEN_EGG_POP, 1F, 1F);
				}

			}
		}

		// Best
		for (Location loc : MapManager.getBowBlocks()) {

			if (block.getLocation().equals(loc)) {

				if (block.getType() == Material.EMERALD_BLOCK) {

					inv.clear();
					ItemStack arrow = new ItemStack(Material.ARROW, 32);

					inv.addItem(Items.getBow());
					inv.addItem(arrow);

					block.setType(Material.REDSTONE_LAMP_OFF);

					Utils.msg(player, ChatColor.GREEN + "RESTOCKED!");
					
					DanEffectAPI.playEffect(location, Particles.LARGE_SMOKE, 1F, 10);
					
					world.playSound(location, Sound.CHICKEN_EGG_POP, 1F, 1F);
				}
			}

		}

		// Bow
		for (Location loc : MapManager.getBestBlocks()) {
			if (block.getLocation().equals(loc)) {

				if (block.getType() == Material.EMERALD_BLOCK) {

					inv.clear();

					inv.addItem(Items.getBestSword());

					block.setType(Material.REDSTONE_LAMP_OFF);

					Utils.msg(player, ChatColor.GREEN + "RESTOCKED!");
					
					DanEffectAPI.playEffect(location, Particles.LARGE_SMOKE, 1F, 10);
					
					world.playSound(location, Sound.CHICKEN_EGG_POP, 1F, 1F);
				}
			}

		}
	}

}
