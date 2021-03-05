package com.theconsolelog.game;

import org.bukkit.Location;
import org.bukkit.entity.Player;

public class BattlePlayer {

	private final Player player;
	private boolean vulnerable;

	public BattlePlayer (Player player) {
		this.player = player;
		this.vulnerable = true;
	}

	public void setVulnerable (boolean vulnerable) {
		this.vulnerable = vulnerable;
	}

	public boolean isVulnerable () {
		return this.vulnerable;
	}

	public void heal () {
		this.player.setMaxHealth (20);
		this.player.setHealthScale (20);
		this.player.setFoodLevel (20);
	}

	public void teleport (Location location) {
		this.player.teleport (location);
	}
}
