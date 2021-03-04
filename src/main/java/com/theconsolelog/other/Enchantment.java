package com.theconsolelog.other;

import lombok.Getter;

@Getter
public class Enchantment {

	private final org.bukkit.enchantments.Enchantment enchantment;
	private int value;
	private boolean value2;

	public Enchantment (org.bukkit.enchantments.Enchantment enchantment) {
		this.enchantment = enchantment;
	}

	public Enchantment setValue (int value) {
		this.value = value;
		return this;
	}

	public Enchantment setValue2 (boolean value2) {
		this.value2 = value2;
		return this;
	}
}
