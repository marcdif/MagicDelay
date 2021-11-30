package com.marcdif.magicdelay.commands;

import com.marcdif.magicdelay.MagicDelay;
import com.marcdif.magicdelay.utils.MathUtil;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.BlockCommandSender;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class DelayCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command c, String label, String[] args) {
        if (!(sender instanceof BlockCommandSender)) {
            sender.sendMessage(ChatColor.YELLOW + "" + ChatColor.ITALIC + "This command can only be run by command blocks");
            sender.sendMessage(ChatColor.RED + "/delay [delay in seconds] x y z");
            return true;
        }
        if (args.length != 4) {
            sender.sendMessage(ChatColor.RED + "Incorrect amount of arguments!");
            return true;
        }
        try {
            Location currentLocation = ((BlockCommandSender) sender).getBlock().getLocation();
            int x = MathUtil.getCoordinate(args[1], currentLocation.getBlockX());
            int y = MathUtil.getCoordinate(args[2], currentLocation.getBlockY());
            int z = MathUtil.getCoordinate(args[3], currentLocation.getBlockZ());
            Location loc = new Location(((BlockCommandSender) sender).getBlock().getWorld(), x, y, z);
            long delay = (long) (20 * (Double.parseDouble(args[0])));
            if (!loc.getChunk().isLoaded()) loc.getChunk().load();

            MagicDelay.getDelayUtil().logDelay(loc, delay, Material.REDSTONE_BLOCK);
        } catch (IllegalArgumentException e) {
            sender.sendMessage(ChatColor.DARK_RED + "Error: " + e.getMessage());
            sender.sendMessage(ChatColor.RED + "/delay [delay in seconds] x y z");
        }
        return true;
    }
}
