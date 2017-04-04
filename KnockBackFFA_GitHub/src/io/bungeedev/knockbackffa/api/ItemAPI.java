package io.bungeedev.knockbackffa.api;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

/**
 * @author BungeeDev
 **/
public class ItemAPI {
 
    public static ItemStack createjoinItem(Material mat, int amount, int shortid, String DisplayName, Enchantment ench, int level) {
        short s = (short) shortid;
        ItemStack item = new ItemStack(mat, amount, s);
        ItemMeta meta = item.getItemMeta();
        meta.addEnchant(ench, level, true);
        meta.setDisplayName(DisplayName);
        item.setItemMeta(meta);
        return item;
    }    
}