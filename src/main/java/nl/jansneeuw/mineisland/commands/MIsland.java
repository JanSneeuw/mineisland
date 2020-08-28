package nl.jansneeuw.mineisland.commands;

import com.sk89q.worldguard.bukkit.WGBukkit;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;
import nl.jansneeuw.mineisland.Mineisland;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

public class MIsland implements CommandExecutor {

    private Mineisland mineisland;
    public MIsland(Mineisland mineisland){
        this.mineisland = mineisland;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 2 && sender instanceof Player && sender.hasPermission("mineisland.commands")){
            Player player = (Player) sender;
            if (args[0].equalsIgnoreCase("define")){
                if (WGBukkit.getRegionManager(player.getWorld()).getRegion(args[1]) != null){
                    if (!mineisland.getConfig().getList("regions").contains(args[1])){
                        List<String> list = mineisland.getConfig().getStringList("regions");
                        list.add(args[1]);
                        mineisland.getConfig().set("regions", list);
                        mineisland.saveConfig();
                        player.sendMessage(ChatColor.GREEN + "Added " + args[1] + " as a mine!");
                    }else{
                        player.sendMessage(ChatColor.RED + "That mineisland already exists!");
                    }
                }else{
                    player.sendMessage(ChatColor.RED + "That region does not exist!");
                }
            }else if (args[0].equalsIgnoreCase("remove") && player.hasPermission("mineisland.commands")){
                if (mineisland.getConfig().getList("regions") != null && mineisland.getConfig().getStringList("regions").contains(args[1])){
                    List<String> mines = mineisland.getConfig().getStringList("regions");
                    mines.remove(args[1]);
                    mineisland.getConfig().set("regions", mines);
                    mineisland.saveConfig();
                    mineisland.saveConfig();
                    player.sendMessage(ChatColor.GREEN + args[1] + " removed from mineislands.");
                }else{
                    player.sendMessage(ChatColor.RED + "Sorry, this region in not currently a mineisland.");
                }
            }
        }
        return true;
    }
}
