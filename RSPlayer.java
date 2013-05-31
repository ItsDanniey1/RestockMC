package me.ItsDanniey1.Restock;

import me.ItsDanniey1.Restock.GameLogic.Cache;


public class RSPlayer {

	private String name;
	private int kills;
	private int deaths;
	private int powerupsUsed;

	public RSPlayer(String name) {
		this.name = name;
		this.kills = 0;
		this.deaths = 0;
		this.powerupsUsed = 0;
	}
	
	public int addKill() {
		this.kills = this.kills+1;
		return this.kills;
	}
	
	public int addDeath() {
		this.deaths = this.deaths+1;
		return this.deaths;
	}
	
	public int addPowerup() {
		this.powerupsUsed = this.powerupsUsed+1;
		return this.powerupsUsed;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getKills() {
		return this.kills;
	}
	
	public int getDeaths() {
		return this.deaths;
	}
	
	public int getPowerupsUsed() {
		return this.powerupsUsed;
	}
	
	public void save() {
		Cache.RSPlayers.put(this.name, this);
	}
}
 
