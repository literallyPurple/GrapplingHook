package com.literallyprpl.grapplinghook;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        ItemManager.init();
        getCommand("gh").setExecutor(new Commands());
        getServer().getPluginManager().registerEvents(new ItemEvents(this), this);
        Cooldown.setupCooldown();
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[GrapplingHook] Plugin Loaded!");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "[GrapplingHook] Shutting Down!");
    }
}
