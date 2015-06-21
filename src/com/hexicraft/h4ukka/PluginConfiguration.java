package com.hexicraft.h4ukka;

/**
 * Created by H4 on 17.6.2015.
 */

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class PluginConfiguration {

    private JavaPlugin plugin;

    private File configFile;
    private FileConfiguration config;

    PluginConfiguration (JavaPlugin plugin) {
        this.plugin = plugin;

        configFile = new File(plugin.getDataFolder(), "config.yml");
        config = new YamlConfiguration();

        this.loadConfiguration();
    }

    public void loadConfiguration () {
        try {
            plugin.getLogger().info("Loading configuration file...");
            config.load(configFile);
        } catch (InvalidConfigurationException | IOException e1) {
            plugin.getLogger().warning("Error loading configuration file.\n" + e1.getMessage());
        }
    }

    public String getString (String path) {
        return config.getString(path);
    }

    public List<String> getStringList (String path) { return config.getStringList(path); }

}
