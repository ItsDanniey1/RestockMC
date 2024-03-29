package me.ItsDanniey1.Restock.GameLogic;

import me.ItsDanniey1.Restock.Items;
import me.ItsDanniey1.Restock.GameLogic.Cache;
import me.ItsDanniey1.Restock.GameLogic.MapManager;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.Inventory;

public class PlayerMovement implements Listener {

	@EventHandler(priority = EventPriority.HIGH)
	public void onMovement(PlayerMoveEvent event) {

		if (StateManager.getState() == GameState.WARMUP) {

			int spawn = Cache.usedSpawns.get(event.getPlayer().getName());

			Location location = new Location(MapManager.getWorld(),
					MapManager.getSpawns()[spawn][0],
					MapManager.getSpawns()[spawn][1],
					MapManager.getSpawns()[spawn][2], event.getPlayer()
							.getLocation().getYaw(), event.getPlayer()
							.getLocation().getPitch());

			if (!event.getPlayer().getLocation().equals(location)) {
				event.getPlayer().teleport(location);
			}
		}
	}

	@EventHandler
	public void onPlayerDamage(EntityDamageByEntityEvent event) {
		if (StateManager.getState() == GameState.WAITING) {
			Entity e = event.getEntity();
			if (e instanceof Player) {
				event.setCancelled(true);
			}
		}

		if (StateManager.getState() == GameState.WARMUP) {
			Entity e1 = event.getEntity();
			if (e1 instanceof Player) {
				event.setCancelled(true);
			}
		}

		if (StateManager.getState() == GameState.ENDED) {
			Entity e2 = event.getEntity();
			if (e2 instanceof Player) {
				event.setCancelled(true);
			}
		}
	}

	@EventHandler
	public void spawninrightMap(PlayerMoveEvent event) {

		Player player = event.getPlayer();

		if (player.getLocation().getBlockY() == 32) {
			
			World world = Bukkit.getServer().getWorld(MapManager.worldList[0]);
			Location lobbyspawn = new Location(world, 0, 105, 0, 0, 0);

			player.teleport(lobbyspawn);
			player.setGameMode(GameMode.ADVENTURE);
				Inventory inv = player.getInventory();
				inv.clear();
				inv.addItem(Items.getBook());
				
				player.setHealth(20);
				player.setFoodLevel(200);
				if(Cache.AlivePlayers.containsKey(player)) {
				Cache.AlivePlayers.remove(player);

			}
		}
	}
}
