package com.hexicraft.h4ukka;

import com.vexsoftware.votifier.model.Vote;
import com.vexsoftware.votifier.model.VotifierEvent;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ComponentBuilder;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;
import java.util.Random;

/**
 * Created by H4 on 17.6.2015.
 */

public class Hexifier extends JavaPlugin implements Listener {

    private PluginConfiguration config = new PluginConfiguration(this);

    @Override
    public void onEnable () {

        getServer().getPluginManager().registerEvents(this, this);

    }

    @EventHandler(priority= EventPriority.NORMAL)
    public void onVotifierEvent(VotifierEvent event) {

        Vote vote = event.getVote();

        List<String> messages = config.getStringList("messages");

        Random rand = new Random();
        String  message = messages.get(rand.nextInt(messages.size()));

        message = message.replace("{user}", vote.getUsername());


        Bukkit.spigot().broadcast(new ComponentBuilder(ChatColor.translateAlternateColorCodes('&', message)).create());
    }

}
