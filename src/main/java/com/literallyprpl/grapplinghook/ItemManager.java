package com.literallyprpl.grapplinghook;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ItemManager {

    public static ItemStack GrapplingHook;

    public static void init(){
        createHook();
    }

    private static void createHook(){
        ItemStack item = new ItemStack(Material.FISHING_ROD, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§9Grappling Hook");
        meta.setUnbreakable(true);
        List<String> lore = new ArrayList<>();
        lore.add("§7Right Click To Use!");
        lore.add("§7Flings you around!");
        meta.setLore(lore);
        meta.setCustomModelData(1);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_UNBREAKABLE);
        item.setItemMeta(meta);
        GrapplingHook = item;

        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("hook"), item);
        sr.shape("DD ", "DB ", "  B");
        sr.setIngredient('D', Material.DIAMOND);
        sr.setIngredient('B', Material.BLAZE_ROD);
        Bukkit.getServer().addRecipe(sr);
    }
}
