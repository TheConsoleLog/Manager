package com.theconsolelog.files;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;

public class YmlFile {

	private final File file;
	private final YamlConfiguration configuration;

	public YmlFile (String name, Plugin plugin) {
		String folder = plugin.getDataFolder ().getPath ();
		this.file = new File (folder, name + ".yml");
		if (! file.exists ()) {
			try { file.createNewFile (); } catch (IOException ignored) {}
		}
		this.configuration = YamlConfiguration.loadConfiguration (this.file);
	}

	public YmlFile setDefault (String key, Object value) {
		if (this.configuration.isSet (key)) {
			return this;
		}

		this.setValue (key, value);
		return this;
	}

	public YmlFile setValue (String key, Object value) {
		this.configuration.set (key, value);
		return this;
	}

	public File getFile () {
		return this.file;
	}

	public boolean isSet (String key) {
		return this.configuration.isSet (key);
	}

	public YamlConfiguration getConfiguration () {
		return this.configuration;
	}

	public Object getObject (String name) {
		return this.configuration.get (name);
	}

	public YmlFile save () {
		try { this.configuration.save (this.file); } catch (IOException e) { e.printStackTrace (); }
		return this;
	}
}