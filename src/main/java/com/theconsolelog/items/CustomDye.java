package com.theconsolelog.items;

import com.theconsolelog.other.Enchantment;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CustomDye {

	private final String NAME;
	private int amount;
	private DyeColor color;
	private List<String> lore;
	private final List<Enchantment> enchantment;
	private boolean unbreakable;

	public CustomDye (String name) {
		this.NAME = name;
		this.amount = 1;
		this.color = DyeColor.WHITE;
		this.lore = new ArrayList<> ();
		this.enchantment = new ArrayList<> ();
		this.unbreakable = false;
	}

	public CustomDye setAmount (int amount) {
		this.amount = amount;
		return this;
	}

	public CustomDye setColor (DyeColor color) {
		this.color = color;
		return this;
	}

	public CustomDye setLore (List<String> lore) {
		this.lore = lore;
		return this;
	}

	public CustomDye setLore (String... lore) {
		this.lore = Arrays.asList(lore);
		return this;
	}

	public CustomDye setUnbreakable (boolean unbreakable) {
		this.unbreakable = unbreakable;
		return this;
	}

	public CustomDye addEnchantment (org.bukkit.enchantments.Enchantment enchantment, byte value, boolean value2) {
		this.enchantment.add (new Enchantment (enchantment).setValue (value).setValue (2));
		return this;
	}

	public ItemStack create () {
		ItemStack dye = new ItemStack (Material.INK_SACK, amount, color.getDyeData ());
		ItemMeta meta = dye.getItemMeta ();
		meta.setDisplayName (this.NAME);
		if (lore != null) meta.setLore (this.lore);
		if (!enchantment.isEmpty ()) {
			enchantment.forEach (en -> meta.addEnchant (en.getEnchantment (), en.getValue (), en.isValue2 ()));
		}
		meta.setUnbreakable (this.unbreakable);
		dye.setItemMeta (meta);
		return dye;
	}
}
