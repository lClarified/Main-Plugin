package stat;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Commands extends JavaPlugin {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd,String Label,String[] args) {
        Player player = (Player) sender;
        if (cmd.getName().equals("stathelp")) {
            if (sender instanceof Player) {
                player.sendMessage("/stat:돈 : /돈 [후행데이터] [닉네임] [Integer] | /돈 [후행데이터] [닉네임] ");
                player.sendMessage("/stat:돈입금 : /돈입금 [닉네임] [Integer]");
                player.sendMessage("/stat:레벨 : /레벨 [후행데이터] [닉네임] (Permission Command)");
                player.sendMessage("/stat:돈추가 : /돈추가 [닉네임] [Integer] (Permission Command)");
            } else {
                Bukkit.getLogger().warning("이 플러그인은 콘솔에서 사용할수 있는 명령어가 없습니다 :(");
            }


        }
        return false;
    }

}
