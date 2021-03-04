package com.theconsolelog.items;

import com.theconsolelog.other.Enchantment;
import com.theconsolelog.other.GlassColor;
import com.theconsolelog.other.GlassType;
import lombok.Getter;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
public class CustomGlass {

	private final String NAME;
	private int amount;
	private GlassColor color;
	private GlassType type;
	private List<String> lore;
	private boolean unbreakable;
	private final List<Enchantment> enchantment;

	public CustomGlass (String name) {
		this.NAME = name;
		this.amount = 1;
		this.color = GlassColor.white;
		this.unbreakable = false;
		this.type = GlassType.STAINED_GLASS_PANE;
		this.lore = new ArrayList<> ();
		this.enchantment = new ArrayList<> ();
	}

	public CustomGlass setAmount (int amount) {
		this.amount = amount;
		return this;
	}

	public CustomGlass setColor (GlassColor color) {
		this.color = color;
		return this;
	}

	public CustomGlass setGlassType (GlassType type) {
		this.type = type;
		return this;
	}

	public CustomGlass setLore (List<String> lore) {
		this.lore = lore;
		return this;
	}

	public CustomGlass setLore (String... lore) {
		this.lore = Arrays.asList (lore);
		return this;
	}

	public CustomGlass setUnbreakable (boolean unbreakable) {
		this.unbreakable = unbreakable;
		return this;
	}

	public CustomGlass addEnchantment (org.bukkit.enchantments.Enchantment enchantment, int value, boolean value2) {
		this.enchantment.add (new Enchantment (enchantment).setValue (value).setValue2 (value2));
		return this;
	}

	public ItemStack create () {
		ItemStack itemStack = new ItemStack (type.getMaterial (), amount, (byte) color.getID ());
		ItemMeta meta = itemStack.getItemMeta ();
		meta.setDisplayName (this.NAME);
		if(!lore.isEmpty ()) meta.setLore (this.lore);
		meta.setUnbreakable (unbreakable);
		if (!enchantment.isEmpty ()) {
			enchantment.forEach (en -> meta.addEnchant (en.getEnchantment (), en.getValue (), en.isValue2 ()));
		}
		itemStack.setItemMeta (meta);
		return itemStack;
	}
}
