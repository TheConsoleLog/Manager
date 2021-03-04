package com.theconsolelog.other;

import org.bukkit.Material;

public enum GlassType {

	STAINED_GLASS_PANE (Material.STAINED_GLASS_PANE),
	STAINED_GLASS (Material.STAINED_GLASS),
	GLASS (Material.GLASS);

	private final Material material;
	GlassType (Material material) {
		this.material = material;
	}
	public Material getMaterial () {
		return this.material;
	}
}
