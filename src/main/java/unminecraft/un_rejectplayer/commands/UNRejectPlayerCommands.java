package unminecraft.un_rejectplayer.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class UNRejectPlayerCommands implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {


        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players can use that command!");
            return true;
        }
        Player player = (Player) sender;

        if (cmd.getName().equalsIgnoreCase("saludo")){
            player.sendMessage("§e§l(!) §eHello bro!");
        }

        return true;
    }
}

