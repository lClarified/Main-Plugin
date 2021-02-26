package stat.leveling;

import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDeathEvent;

public class level {
	
	
	@EventHandler
	public void onDeath(EntityDeathEvent e) {
		Entity killer = e.getEntity().getKiller();
		Entity entity = e.getEntity();
		if (killer instanceof Player){
			if (entity.getType().equals(EntityType.ZOMBIE)) {
				stat.leveling.leveling.adden(5, 0, killer);
                killer.sendMessage("5xp 를 얻으셨습니다!");
            } else if (entity.getType().equals(EntityType.HUSK)) {
				stat.leveling.leveling.adden(5, 0, killer);
                killer.sendMessage("5xp 를 얻으셨습니다!");
            }else if (entity.getType().equals(EntityType.SKELETON)) {
                stat.leveling.leveling.adden(5, 0, killer);
                killer.sendMessage("5xp 를 얻으셨습니다!");
            }else if (entity.getType().equals(EntityType.SKELETON_HORSE)) {
                stat.leveling.leveling.adden(5, 0, killer);
                killer.sendMessage("5xp 를 얻으셨습니다!");
            }else if (entity.getType().equals(EntityType.STRAY)) {
                stat.leveling.leveling.adden(5, 0, killer);
                killer.sendMessage("5xp 를 얻으셨습니다!");
            }else if (entity.getType().equals(EntityType.WITHER)) {
                stat.leveling.leveling.adden(0, 3, killer);
                killer.sendMessage("5xp 를 얻으셨습니다!");
            }else if (entity.getType().equals(EntityType.WITHER_SKELETON)) {
                stat.leveling.leveling.adden(5, 0, killer);
                killer.sendMessage("5xp 를 얻으셨습니다!");
            }else if (entity.getType().equals(EntityType.ENDER_DRAGON)) {
                stat.leveling.leveling.adden(0, 2, killer);
                killer.sendMessage("5xp 를 얻으셨습니다!");
            }else if (entity.getType().equals(EntityType.ZOMBIE_HORSE)) {
                stat.leveling.leveling.adden(5, 0, killer);
                killer.sendMessage("5xp 를 얻으셨습니다!");
            }else if (entity.getType().equals(EntityType.ZOMBIE_VILLAGER)) {
                stat.leveling.leveling.adden(5, 0, killer);
                killer.sendMessage("5xp 를 얻으셨습니다!");
            }
		}
	}
}
