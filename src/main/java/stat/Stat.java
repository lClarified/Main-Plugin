package stat;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.event.Listener;
import org.bukkit.scoreboard.*;
import org.bukkit.entity.*;
import org.bukkit.entity.Player;
import com.destroystokyo.paper.network.StatusClient;
import java.awt.*;
import java.io.File;
import java.lang.annotation.Inherited;
import java.math.BigDecimal;
import java.util.*;
import java.util.logging.Logger;
import stat.leveling.level;
import static java.lang.Integer.MAX_VALUE;
import net.milkbowl.vault.chat.Chat;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.economy.EconomyResponse;
import net.milkbowl.vault.permission.Permission;

public class Stat extends JavaPlugin implements CommandExecutor {

    private static final Logger log = Logger.getLogger("Minecraft");
    private static Economy econ = null;
    private static Permission perms = null;
    private static Chat chat = null;

    @Override
    public void onEnable() {
        //Plugin Startup Logic
        Bukkit.getLogger().info("Enabled!");
        getCommand("statptest");
        if (!setupEconomy()) {
            log.severe(String.format("[%s] - Disabled due to no Vault dependency found!", getDescription().getName()));
            getServer().getPluginManager().disablePlugin(this);
            return;
        }
        setupPermissions();
        setupChat();
    }
    @Override
    public void onDisable() {
        //Plugin Shutdown Logic
        Bukkit.getLogger().info("Disabled!");
    }
    private boolean setupEconomy() {
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        econ = rsp.getProvider();
        return econ != null;
    }

    private boolean setupChat() {
        RegisteredServiceProvider<Chat> rsp = getServer().getServicesManager().getRegistration(Chat.class);
        chat = rsp.getProvider();
        return chat != null;
    }

    private boolean setupPermissions() {
        RegisteredServiceProvider<Permission> rsp = getServer().getServicesManager().getRegistration(Permission.class);
        perms = rsp.getProvider();
        return perms != null;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String Label, String[] args) {
        Player player = (Player) sender;
        if (cmd.getName().equals("statptest")) {
            player.sendMessage("Test");

        }
        return true;

    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        ScoreboardManager manager = Bukkit.getScoreboardManager();
        Scoreboard board = manager.getNewScoreboard();

        Objective objective = board.registerNewObjective("yns", "dummy");

        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        objective.setDisplayName("???????" + new Color(252, 168, 187));


        String name = player.getName();
        Permission perm = getPermissions();

            Score score1 = objective.getScore("닉네임");
            score1.setScore(1);

            Score score2 = objective.getScore(name);
            score2.setScore(2);

            Score score3 = objective.getScore("");
            score3.setScore(3);

            Score score4 = objective.getScore("레벨");
            score4.setScore(4);

            Score score5 = objective.getScore("" + stat.leveling.leveling.getlevel(player));
            score5.setScore(5);

            Score score6 = objective.getScore("");
            score6.setScore(6);

            Score score7 = objective.getScore("필요 경험치");
            score7.setScore(7);

            Score score8 = objective.getScore(stat.leveling.leveling.getxp(player) + "/" + "2500");
            score8.setScore(8);

            Score score9 = objective.getScore("");
            score9.setScore(9);


            Score score10 = objective.getScore("돈");
            score10.setScore(10);

            Score score11 = objective.getScore(econ.format(econ.getBalance(player.getName())));
            score11.setScore(11);

            Score score12 = objective.getScore("");
            score12.setScore(12);

            Score score13 = objective.getScore("");
            score10.setScore(13);

            Objective objective2 = board.registerNewObjective("hp", "dummy");

            double hp = player.getHealth();

            objective2.setDisplaySlot(DisplaySlot.BELOW_NAME);
            objective2.setDisplayName("hp" + hp);
            //체력 표시

            Objective objective3 = board.registerNewObjective("tab", "dummy");

            objective3.setDisplaySlot(DisplaySlot.PLAYER_LIST);
            objective3.setDisplayName("이 서버는 이제 제겁니다 서버");
            //플레이어 목록 하단에 글자 표시

            if (!player.hasPlayedBefore()) {
                player.sendMessage(name + "님의 현재 레벨은 1입니다!");
                Bukkit.getServer().broadcastMessage(name + "님 야생서버에 오신것을 환영합니다!");


            }

        }

    public static Economy getEconomy() {
        return econ;
    }

    public static Permission getPermissions() {
        return perms;
    }

    public static Chat getChat() {
        return chat;
    }
}
