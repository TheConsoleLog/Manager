package com.theconsolelog.files;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.bukkit.plugin.Plugin;

import java.io.*;
import java.nio.file.Files;

public class JsonFile {

	public static final Gson GSON = new GsonBuilder ().setPrettyPrinting ().create ();
	private final File FILE;

	public JsonFile (String name, Plugin plugin) {
		String folder = plugin.getDataFolder ().getPath ();
		this.FILE = new File (folder, name + ".json");
		if (! FILE.exists ()) {
			try { FILE.createNewFile (); } catch (IOException ignored) {}
		}
	}

	public JsonFile (String name, Plugin plugin, Object def) {
		String folder = plugin.getDataFolder ().getPath ();
		this.FILE = new File (folder, name + ".json");
		if (! FILE.exists ()) {
			try {
				FILE.createNewFile ();
				saveData (def);
			} catch (IOException ignored) {}
		}
	}

	public <T> void saveData (Object obj) throws IOException {
		String json = GSON.toJson (obj);
		Files.write (FILE.toPath (), json.getBytes ());
	}

	public <T> T loadData (Class<T> type) throws FileNotFoundException {
		return GSON.fromJson (new InputStreamReader (new FileInputStream (FILE)), type);
	}
}
