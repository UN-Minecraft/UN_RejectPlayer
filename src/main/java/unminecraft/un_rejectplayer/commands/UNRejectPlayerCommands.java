package unminecraft.un_rejectplayer.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import unminecraft.un_rejectplayer.UN_RejectPlayer;

public class UNRejectPlayerCommands implements CommandExecutor {
    private final UN_RejectPlayer plugin;

    public  UNRejectPlayerCommands(UN_RejectPlayer plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (sender instanceof Player) {
            sender.sendMessage("Only server can use that command!");
            return true;
        }

        if (cmd.getName().equalsIgnoreCase("reloadunrp")){
            plugin.reloadConfig();
            Bukkit.getServer().getPluginManager().disablePlugin(plugin);
            Bukkit.getServer().getPluginManager().enablePlugin(plugin);
        }

        return true;
    }
}

