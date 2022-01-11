package com.literallyprpl.grapplinghook;

import jdk.tools.jlink.plugin.Plugin;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commands implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(!(sender instanceof Player)){
            sender.sendMessage("Only players can use that command!");
            return true;
        }

        Player player = (Player) sender;
        if (label.equalsIgnoreCase("gh")) {
            if (!sender.hasPermission("gh.give")) {
                sender.sendMessage(ChatColor.RED + "You don't have permission to use this command!");
                return true;
            }
            if (args.length == 0) {
                // /gh
                sender.sendMessage(ChatColor.RED + "Usage: /gh give");
                return true;
            }
            if (args.length > 0) {
                // /gh give
                if (args[0].equalsIgnoreCase("give")) {
                    player.getInventory().addItem(ItemManager.GrapplingHook);
                }
                // /gh reload
                if (args[0].equalsIgnoreCase("reload")) {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Main.getPlugin(Main.class).getConfig().getString("reload.message")));
                    Main.getPlugin(Main.class).reloadConfig();
                }
            }
        }
        return true;
    }
}
