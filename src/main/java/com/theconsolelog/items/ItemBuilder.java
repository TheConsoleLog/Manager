package com.theconsolelog.items;

import lombok.Data;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.MaterialData;

import java.util.List;

@Data
public class ItemBuilder {

	private final ItemStack itemStack;
	protected ItemMeta itemMeta;

	public ItemBuilder (Material material, String displayname) {
		this.itemStack = new ItemStack (material);
		this.itemMeta = this.itemStack.getItemMeta ();
		this.itemMeta.setDisplayName (displayname);
		this.itemStack.setAmount (1);
	}

	public ItemBuilder addEnchantment (Enchantment enchantment, int i, boolean b) {
		this.itemMeta.addEnchant (enchantment, i, b);
		return this;
	}

	// set color
	public ItemBuilder setDurability (int durability) {
		this.itemStack.setDurability ((short) durability);
		return this;
	}

	public ItemBuilder setLore (List<String> list) {
		this.itemMeta.setLore (list);
		return this;
	}

	public ItemBuilder setUnbreakable () {
		this.itemMeta.spigot ().setUnbreakable (true);
		return this;
	}

	public ItemBuilder setAmount (int amount) {
		this.itemStack.setAmount (amount);
		return this;
	}

	public ItemBuilder setData (MaterialData data) {
		this.itemStack.setData (data);
		return this;
	}

	public ItemStack create () {
		this.itemStack.setItemMeta (this.itemMeta);
		return this.itemStack;
	}
}
