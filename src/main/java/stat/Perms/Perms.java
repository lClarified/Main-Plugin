package stat.Perms;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.plugin.java.JavaPlugin;


public class Perms extends JavaPlugin {

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled=true)
    public void BlockBreakEvent(BlockBreakEvent e, Cancellable cancellable) {
        Player player = e.getPlayer();
        if (player.hasPermission("Not_Verified")) {
            e.setCancelled(true);
        }
    }
    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled=true)
    public void BlockPlaceEvent(BlockPlaceEvent e) {
        Player player = e.getPlayer();
        if (player.hasPermission("Not_Verified")) {
            e.setCancelled(true);
        }
    }

    }
