package com.literallyprpl.grapplinghook;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemEvents implements Listener {

    private Main main;

    public ItemEvents(Main main) {
        this.main = main;
    }

    @EventHandler
    public void onFish(PlayerFishEvent event) {
        Player player = event.getPlayer();
        ItemStack item = player.getInventory().getItemInMainHand();
        ItemMeta meta = item.getItemMeta();
        String name = meta.getDisplayName();
        if(name.equals("§9Grappling Hook")) {
            if(event.getState().equals(PlayerFishEvent.State.REEL_IN)) {
                if (Cooldown.checkCooldown(event.getPlayer())) {
                    Location playerLoc = player.getLocation();
                    Location hookLoc = event.getHook().getLocation();
                    Location change = hookLoc.subtract(playerLoc);
                    player.setVelocity(change.toVector().multiply(0.3));
                    Cooldown.setCooldown(event.getPlayer(), main.getConfig().getInt("Cooldown"));
                }
                else {
                    player.sendMessage(ChatColor.DARK_RED + "Grappling Hook is not ready yet!");
                }
            }
        }
    }
}
