package com.theconsolelog.manager;

import org.bukkit.plugin.java.JavaPlugin;

public final class Manager extends JavaPlugin {

	private static Manager manager;

	public static Manager getManager () {
		return manager;
	}

	@Override
	public void onEnable () {
		manager = this;
	}

	@Override
	public void onDisable () {
	}
}
