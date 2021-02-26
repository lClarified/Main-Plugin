package stat.Gui;

import net.milkbowl.vault.chat.Chat;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.permission.Permission;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.logging.Logger;

import static stat.Stat.getPermissions;

public class Gui1 extends JavaPlugin {

    private static final Logger log = Logger.getLogger("Minecraft");
    private static Economy econ = null;
    private static Permission perms = null;
    private static Chat chat = null;
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String Label, String[] args) {
        Player player = (Player) sender;
        if (sender instanceof Player) {
            if (cmd.getName().equals("stat")) {
                if (args.length == 0) {
                    String name = player.getServer().getName();
                    if (args[0] == null) {
                        Inventory gui = Bukkit.createInventory(player, 9, ChatColor.GOLD + name + "님의 스탯");

                        ItemStack slot_exp = new ItemStack(Material.EXPERIENCE_BOTTLE);
                        ItemStack slot_level = new ItemStack(Material.EXPERIENCE_BOTTLE);
                        ItemStack slot_money = new ItemStack(Material.PAPER);
                        ItemStack slot_null = new ItemStack(Material.BARRIER);
                        ItemStack slot_world = new ItemStack(Material.COMPASS);

                        ItemMeta slot_expMeta = slot_exp.getItemMeta();
                        slot_expMeta.setDisplayName(ChatColor.GREEN + stat.leveling.leveling.getxp(player));
                        ArrayList <String> exp_lore = new ArrayList<>();
                        exp_lore.add(ChatColor.GREEN + "EXP");
                        slot_expMeta.setLore(exp_lore);

                        ItemMeta slot_levelMeta = slot_level.getItemMeta();
                        slot_expMeta.setDisplayName(ChatColor.GREEN + stat.leveling.leveling.getlevel(player));
                        ArrayList <String> level_lore = new ArrayList<>();
                        exp_lore.add(ChatColor.GREEN + "Level");
                        slot_levelMeta.setLore(level_lore);;

                        ItemMeta slot_moneyMeta = slot_money.getItemMeta();
                        slot_expMeta.setDisplayName(ChatColor.GREEN + econ.format(econ.getBalance(player)));
                        ArrayList <String> money_lore = new ArrayList<>();
                        exp_lore.add(ChatColor.GREEN + "Money");
                        slot_moneyMeta.setLore(money_lore);

                        ItemMeta slot_nullMeta = slot_null.getItemMeta();
                        slot_nullMeta.setDisplayName(ChatColor.BLACK + "@NULL@");

                        ItemMeta slot_worldMeta = slot_world.getItemMeta();
                        String world = player.getServer().getWorldType();
                        slot_worldMeta.setDisplayName(world);


                        gui.setItem(0, slot_exp);
                        gui.setItem(1, slot_null);
                        gui.setItem(2, slot_level);
                        gui.setItem(3, slot_null);
                        gui.setItem(4, slot_money);
                        gui.setItem(5, slot_null);
                        gui.setItem(6, slot_null);
                        gui.setItem(6, slot_null);
                        gui.setItem(7, slot_world);
                        gui.setItem(8, slot_null);

                        player.openInventory(gui);

                    }

                }
            } else if (args.length == 1);
            Player target = getServer().getPlayer(args[0]);
            String name = target.getName();
            if (target == null) {
                player.sendMessage(ChatColor.RED + "그 플레이어를 찾을수 없습니다");
            } else if (target == getServer().getPlayer(args[0])) {

                Inventory gui = Bukkit.createInventory(player, 9, ChatColor.GOLD + name + "님의 스탯");

                ItemStack slot_exp = new ItemStack(Material.EXPERIENCE_BOTTLE);
                ItemStack slot_level = new ItemStack(Material.EXPERIENCE_BOTTLE);
                ItemStack slot_money = new ItemStack(Material.PAPER);
                ItemStack slot_null = new ItemStack(Material.BARRIER);
                ItemStack slot_world = new ItemStack(Material.COMPASS);
                ItemStack slot_tpa = new ItemStack(Material.ENDER_PEARL);

                ItemMeta slot_expMeta = slot_exp.getItemMeta();
                slot_expMeta.setDisplayName(ChatColor.GREEN + stat.leveling.leveling.getxp(target));
                ArrayList <String> exp_lore = new ArrayList<>();
                exp_lore.add(ChatColor.GREEN + "EXP");
                slot_expMeta.setLore(exp_lore);

                ItemMeta slot_levelMeta = slot_level.getItemMeta();
                slot_expMeta.setDisplayName(ChatColor.GREEN + stat.leveling.leveling.getlevel(target));
                ArrayList <String> level_lore = new ArrayList<>();
                exp_lore.add(ChatColor.GREEN + "Level");
                slot_levelMeta.setLore(level_lore);;

                ItemMeta slot_moneyMeta = slot_money.getItemMeta();
                slot_expMeta.setDisplayName(ChatColor.GREEN + econ.format(econ.getBalance(target)));
                ArrayList <String> money_lore = new ArrayList<>();
                exp_lore.add(ChatColor.GREEN + "Money");
                slot_moneyMeta.setLore(money_lore);

                ItemMeta slot_nullMeta = slot_null.getItemMeta();
                slot_nullMeta.setDisplayName(ChatColor.BLACK + "@NULL@");

                ItemMeta slot_worldMeta = slot_world.getItemMeta();
                String world = player.getServer().getWorldType();
                slot_worldMeta.setDisplayName(world);

                ItemMeta slot_tpaMeta = slot_tpa.getItemMeta();
                slot_tpaMeta.setDisplayName(ChatColor.BLACK + "tpa");

                gui.setItem(0, slot_exp);
                gui.setItem(1, slot_null);
                gui.setItem(2, slot_level);
                gui.setItem(3, slot_null);
                gui.setItem(4, slot_money);
                gui.setItem(5, slot_null);
                gui.setItem(6, slot_tpa);
                gui.setItem(6, slot_null);
                gui.setItem(7, slot_world);
                gui.setItem(8, slot_null);

                player.openInventory(gui);

            }


        }

        return false;
    }
}




