package unminecraft.un_rejectplayer.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import static org.bukkit.Bukkit.getServer;

public class UNRejectPlayerEvents implements Listener {
    @EventHandler
    public static void onPlayerJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "cmi usermeta " + player.getDisplayName() + " list");
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + player.getDisplayName());
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[UN_RejectPlayer]: Comando ejecutado");
        player.sendMessage(ChatColor.LIGHT_PURPLE + "UNRejectPlayer working!");
    }
}
