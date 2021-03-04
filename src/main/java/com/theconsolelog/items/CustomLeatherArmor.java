package com.theconsolelog.items;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public class CustomLeatherArmor extends ItemBuilder {

	public CustomLeatherArmor (Material material, String displayname) {
		super (material, displayname);
	}

	public CustomLeatherArmor setColor (Color color) {
		((LeatherArmorMeta) super.itemMeta).setColor (color);
		return this;
	}
}
