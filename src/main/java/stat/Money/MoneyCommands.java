package stat.Money;

import net.milkbowl.vault.chat.Chat;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.economy.EconomyResponse;
import net.milkbowl.vault.permission.Permission;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.util.logging.Logger;

public class MoneyCommands extends JavaPlugin implements CommandExecutor {

    private static final Logger log = Logger.getLogger("Minecraft");
    private static Economy econ = null;
    private static Permission perms = null;
    private static Chat chat = null;

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String Label, String[] args) {
        Player player = (Player) sender;
        if (cmd.getName().equals("돈")) {
            if (args.length == 0) {
                if (args[0].equals(null)) {
                    player.sendMessage(ChatColor.RED + "개발자인 커맨드의 머릿속처럼 비었군요.후행 데이터를 입력해주세요");
                    //후행데이터 미입력 오류
                }
            } else if (args[0].equals("보기")) {
                if (args.length == 1) {
                if (args[1].equals(null)) {
                    player.sendMessage(player.getName() + "님의 돈은 현재" + econ.format(econ.getBalance(player.getName())) + "원입니다");
                }
                } else if (args.length == 1) {
                    Player target = getServer().getPlayer(args[1]);
                    if (target == getServer().getPlayer(args[1])) {
                        player.sendMessage(target + "님의 돈은 현재" + econ.format(econ.getBalance(target)) + "입니다");
                    }
                }

            }
        } else if (cmd.getName().equals("돈추가")) {
            if (args.length == 0) {
                if (args[0].equals(null)) {
                    player.sendMessage(ChatColor.RED + "플레이어 'com.jetbrains.jvm.kotlin.lang.null' 를 찾을수 없습니다");

                    }
                }
            } else if (args.length == 1) {
                String.valueOf(args[0]);
                Integer.valueOf(args[1]);
                if (Integer.valueOf(args[1]) == null) {
                    player.sendMessage(ChatColor.RED + "'Integer.valueOf(args[1])' cannot be 'com.jetbrains.jvm.kotlin.lang.null'");
                }
            } else if (args.length == 1) {
            Player target = getServer().getPlayer(args[0]);
            if (target == getServer().getPlayer(args[0])) {
                Integer.valueOf(args[1]);
                if (Integer.valueOf(args[1]) >= 1) {
                EconomyResponse deposit = econ.depositPlayer(target, Integer.valueOf(args[1]));
                player.sendMessage(ChatColor.GOLD + "" + target + "님의 돈에 성공적으로" + Integer.valueOf(args[1]) + "원을 추가했습니다");

            }
        }
        } else if (cmd.getName().equals("돈입금")) {
            if (args.length == 0) {
                if (args[0].equals(null)) {
                    player.sendMessage(ChatColor.RED + "플레이어 'com.jetbrains.jvm.kotlin.lang.null' 를 찾을수 없습니다");
                }
            } else if (args.length == 1) {
                String.valueOf(args[0]);
                Integer.valueOf(args[1]);
                if (Integer.valueOf(args[1]) == null) {
                    player.sendMessage(ChatColor.RED + "'Integer.valueOf(args[1])' cannot be 'com.jetbrains.jvm.kotlin.lang.null'");
                }
            } else if (args.length == 1) {
                Player target = getServer().getPlayer(args[0]);
                if (target == getServer().getPlayer(args[0])) {
                    Integer.valueOf(args[1]);
                    if (Integer.valueOf(args[1]) <= 10000) {
                        player.sendMessage(ChatColor.RED + "'Integer.valueOf(args[1])'는 10000보다 커야됩니다");
                    }
                }
            } else if (args.length == 1) {
                Player target = getServer().getPlayer(args[0]);
                if (target == getServer().getPlayer(args[0])) {
                    Integer.valueOf(args[1]);
                    if (Integer.valueOf(args[1]) >= 10000) {
                        EconomyResponse deposit = econ.depositPlayer(target, Integer.valueOf(args[1]));
                        EconomyResponse withdraw = econ.withdrawPlayer(player, Integer.valueOf(args[1]));
                        player.sendMessage(ChatColor.GOLD + "" + target + "님에게 성공적으로" + Integer.valueOf(args[1]) + "원을 입금했습니다");
                    }
                }
            }
        }
        return false;
        }
    }
