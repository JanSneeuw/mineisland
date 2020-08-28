package nl.jansneeuw.mineisland;

import nl.jansneeuw.mineisland.commands.MIsland;
import nl.jansneeuw.mineisland.events.BlockBreak;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.PluginCommand;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class Mineisland extends JavaPlugin {

    @Override
    public void onEnable() {
        saveDefaultConfig();
        registerEvents(this, new BlockBreak(this));
        PluginCommand mineisland = Bukkit.getPluginCommand("Mineisland");
        mineisland.setExecutor(new MIsland(this));

    }

    @Override
    public void onDisable() {
        for (Location locs : BlockBreak.blocksMap.keySet()){
            locs.getBlock().setType(BlockBreak.blocksMap.get(locs));
        }
    }

    public static void registerEvents(org.bukkit.plugin.Plugin plugin, Listener... listeners) {
        for (Listener listener : listeners) {
            Bukkit.getServer().getPluginManager().registerEvents(listener, plugin);
        }
    }
}
