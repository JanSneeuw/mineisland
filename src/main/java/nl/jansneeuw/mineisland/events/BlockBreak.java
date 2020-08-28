package nl.jansneeuw.mineisland.events;

import com.sk89q.worldguard.bukkit.WGBukkit;
import com.sk89q.worldguard.protection.ApplicableRegionSet;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;
import nl.jansneeuw.mineisland.Mineisland;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import java.util.HashMap;
import java.util.Map;

public class BlockBreak implements Listener {

    private Mineisland mineisland;
    public BlockBreak(Mineisland mineisland){
        this.mineisland = mineisland;
    }

    public static Map<Location, Material> blocksMap = new HashMap<>();

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event){
        if (mineisland.getConfig().getList("regions") != null && mineisland.getConfig().getList("regions").size() > 0 && event.getPlayer().getGameMode() != GameMode.CREATIVE){
            ApplicableRegionSet regions = WGBukkit.getRegionManager(event.getPlayer().getWorld()).getApplicableRegions(event.getBlock().getLocation());
            if (regions.size() > 0){
                for (ProtectedRegion region : regions){
                    if (mineisland.getConfig().getList("regions").contains(region.getId())){
                        if (event.getBlock().getType() == Material.COAL_ORE){
                            event.setCancelled(true);
                            blocksMap.put(event.getBlock().getLocation(), event.getBlock().getType());
                            event.getBlock().setType(Material.BEDROCK);
                            Integer oreRespawn = mineisland.getConfig().getInt("respawn.coal_ore");
                            Location location = event.getBlock().getLocation();
                            BukkitTask respawn = new BukkitRunnable() {
                                @Override
                                public void run() {
                                    if (!location.getWorld().isChunkLoaded(location.getChunk())){
                                        location.getChunk().load(true);
                                    }
                                    location.getBlock().setType(Material.COAL_ORE);
                                    blocksMap.remove(location);
                                }
                            }.runTaskLater(mineisland, 20*oreRespawn);
                            event.getPlayer().getInventory().addItem(new ItemStack(Material.COAL_ORE));
                        }else if (event.getBlock().getType() == Material.DIAMOND_ORE){
                            event.setCancelled(true);
                            blocksMap.put(event.getBlock().getLocation(), event.getBlock().getType());
                            event.getBlock().setType(Material.BEDROCK);
                            Integer oreRespawn = mineisland.getConfig().getInt("respawn.diamond_ore");
                            Location location = event.getBlock().getLocation();
                            BukkitTask respawn = new BukkitRunnable() {
                                @Override
                                public void run() {
                                    if (!location.getWorld().isChunkLoaded(location.getChunk())){
                                        location.getChunk().load(true);
                                    }
                                    location.getBlock().setType(Material.DIAMOND_ORE);
                                    blocksMap.remove(location);
                                }
                            }.runTaskLater(mineisland, 20*oreRespawn);
                            event.getPlayer().getInventory().addItem(new ItemStack(Material.DIAMOND_ORE));
                        }else if (event.getBlock().getType() == Material.EMERALD_ORE){
                            event.setCancelled(true);
                            blocksMap.put(event.getBlock().getLocation(), event.getBlock().getType());
                            event.getBlock().setType(Material.BEDROCK);
                            Integer oreRespawn = mineisland.getConfig().getInt("respawn.emerald_ore");
                            Location location = event.getBlock().getLocation();
                            BukkitTask respawn = new BukkitRunnable() {
                                @Override
                                public void run() {
                                    if (!location.getWorld().isChunkLoaded(location.getChunk())){
                                        location.getChunk().load(true);
                                    }
                                    location.getBlock().setType(Material.EMERALD_ORE);
                                    blocksMap.remove(location);
                                }
                            }.runTaskLater(mineisland, 20*oreRespawn);
                            event.getPlayer().getInventory().addItem(new ItemStack(Material.EMERALD_ORE));
                        }else if (event.getBlock().getType() == Material.GLOWING_REDSTONE_ORE){
                            event.setCancelled(true);
                            blocksMap.put(event.getBlock().getLocation(), event.getBlock().getType());
                            event.getBlock().setType(Material.BEDROCK);
                            Integer oreRespawn = mineisland.getConfig().getInt("respawn.redstone_ore");
                            Location location = event.getBlock().getLocation();
                            BukkitTask respawn = new BukkitRunnable() {
                                @Override
                                public void run() {
                                    if (!location.getWorld().isChunkLoaded(location.getChunk())){
                                        location.getChunk().load(true);
                                    }
                                    location.getBlock().setType(Material.REDSTONE_ORE);
                                    blocksMap.remove(location);
                                }
                            }.runTaskLater(mineisland, 20*oreRespawn);
                            event.getPlayer().getInventory().addItem(new ItemStack(Material.REDSTONE_ORE));
                        }else if (event.getBlock().getType() == Material.GOLD_ORE){
                            event.setCancelled(true);
                            blocksMap.put(event.getBlock().getLocation(), event.getBlock().getType());
                            event.getBlock().setType(Material.BEDROCK);
                            Integer oreRespawn = mineisland.getConfig().getInt("respawn.gold_ore");
                            Location location = event.getBlock().getLocation();
                            BukkitTask respawn = new BukkitRunnable() {
                                @Override
                                public void run() {
                                    if (!location.getWorld().isChunkLoaded(location.getChunk())){
                                        location.getChunk().load(true);
                                    }
                                    location.getBlock().setType(Material.GOLD_ORE);
                                    blocksMap.remove(location);
                                }
                            }.runTaskLater(mineisland, 20*oreRespawn);
                            event.getPlayer().getInventory().addItem(new ItemStack(Material.GOLD_ORE));
                        }else if (event.getBlock().getType() == Material.LAPIS_ORE){
                            event.setCancelled(true);
                            blocksMap.put(event.getBlock().getLocation(), event.getBlock().getType());
                            event.getBlock().setType(Material.BEDROCK);
                            Integer oreRespawn = mineisland.getConfig().getInt("respawn.lapis_ore");
                            Location location = event.getBlock().getLocation();
                            BukkitTask respawn = new BukkitRunnable() {
                                @Override
                                public void run() {
                                    if (!location.getWorld().isChunkLoaded(location.getChunk())){
                                        location.getChunk().load(true);
                                    }
                                    location.getBlock().setType(Material.LAPIS_ORE);
                                    blocksMap.remove(location);
                                }
                            }.runTaskLater(mineisland, 20*oreRespawn);
                            event.getPlayer().getInventory().addItem(new ItemStack(Material.LAPIS_ORE));
                        }else if (event.getBlock().getType() == Material.IRON_ORE){
                            event.setCancelled(true);
                            blocksMap.put(event.getBlock().getLocation(), event.getBlock().getType());
                            event.getBlock().setType(Material.BEDROCK);
                            Integer oreRespawn = mineisland.getConfig().getInt("respawn.iron_ore");
                            Location location = event.getBlock().getLocation();
                            BukkitTask respawn = new BukkitRunnable() {
                                @Override
                                public void run() {
                                    if (!location.getWorld().isChunkLoaded(location.getChunk())){
                                        location.getChunk().load(true);
                                    }
                                    location.getBlock().setType(Material.IRON_ORE);
                                    blocksMap.remove(location);
                                }
                            }.runTaskLater(mineisland, 20*oreRespawn);
                            event.getPlayer().getInventory().addItem(new ItemStack(Material.IRON_ORE));
                        }else {
                            if(mineisland.getConfig().getBoolean("block_unwanted_break")){
                                if (!event.getPlayer().hasPermission("Mineisland.build")) {
                                    event.setCancelled(true);
                                    event.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', mineisland.getConfig().getString("block_unwanted_break_message")));
                                }
                            }

                        }
                    }
                }
            }
        }
    }
}
