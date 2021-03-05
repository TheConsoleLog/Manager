package com.theconsolelog.inventorys;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class InventoryManager {

	private final Inventory inventory;

	public InventoryManager (String name, int size, InventoryHolder holder) {
		this.inventory = Bukkit.createInventory (holder, size, name);
	}

	public InventoryManager addItem (int slot, ItemStack itemStack) {
		this.inventory.setItem (slot, itemStack);
		return this;
	}

	public InventoryManager addItem (int slot, Material material, String name, List<String> lore) {
		ItemStack itemStack = new ItemStack (material);
		ItemMeta itemMeta = itemStack.getItemMeta ();
		itemMeta.setDisplayName (name);
		if (lore != null) itemMeta.setLore (lore);
		itemStack.setItemMeta (itemMeta);

		this.inventory.setItem (slot, itemStack);
		return this;
	}

	public InventoryManager addFromTo (int from, int to, ItemStack itemStack) {
		for (int counter = from; counter < (to + 1); counter++) {
			this.inventory.setItem (counter, itemStack);
		}
		return this;
	}

	public InventoryManager addFromList (int start, List<ItemStack> list) {
		for (byte i = 0; i < list.size (); i++) {
			this.inventory.setItem ((i + start), list.get (i));
		}

		return this;
	}

	public Inventory create () {
		return this.inventory;
	}
}