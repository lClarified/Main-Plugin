package stat.leveling;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class LevelCommands extends JavaPlugin {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String Label, String[] args) {
        Player player = (Player) sender;
        if (cmd.getName().equals("레벨")) {
            if (args.length == 0) {
                if (args[0].equals(null)) {
                    player.sendMessage(ChatColor.RED + "개발자인 커맨드의 머릿속처럼 비었군요.후행데이터를 입력해주세요");
                }
            } else if (args.length == 1) {
                if (args[0].equals("추가")) {
                    Player target = getServer().getPlayer(args[1]);
                    if (args[1].equals(null)) {
                        player.sendMessage(ChatColor.RED + "플레이어 'com.jetbrains.jvm.kotlin.lang.null' 를 찾을수 없습니다");
                    }
                }
            } else if (args.length == 3) {
                if (args[0].equals("추가")) {
                    Player target = getServer().getPlayer(args[1]);
                    Integer.valueOf(args[2]);
                    if (Integer.valueOf(args[2]) == null) {
                        player.sendMessage(ChatColor.RED + "'Integer.valueOf(args[1])' cannot be 'com.jetbrains.jvm.kotlin.lang.null'");
                    }
                }
            } else if (args.length == 3) {
                if (args[0].equals("추가")) {
                    Player target = getServer().getPlayer(args[1]);
                    Integer.valueOf(args[2]);
                    Integer.valueOf(args[3]);
                    if (Integer.valueOf(args[2]) >= 1) {
                        if (Integer.valueOf(args[3]) >= 1 || Integer.valueOf(args[3]) <= 150) {
                            stat.leveling.leveling.addpl(Integer.valueOf(args[2]), Integer.valueOf(args[3]), target);
                            player.sendMessage(target + "님의 레벨에 성공적으로" + Integer.valueOf(args[2]) + "xp ," + Integer.valueOf(args[2]) + "Level 을 추가하였습니다");
                        } else if (Integer.valueOf(args[3]) >= 150) {
                            player.sendMessage(ChatColor.RED + "Integer.valueOf(args[3]은 150을 초과할수 없습니다");
                        }
                    }
                }
            }


        }
        return false;
    }
}
