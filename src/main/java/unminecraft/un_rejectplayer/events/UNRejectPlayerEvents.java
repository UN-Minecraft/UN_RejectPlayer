package unminecraft.un_rejectplayer.events;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import unminecraft.un_rejectplayer.UN_RejectPlayer;

import static org.bukkit.Bukkit.getServer;

public class UNRejectPlayerEvents implements Listener {

    public final String headLog = "[UN_RejectPlayer]: ";
    public final String kickMsg = "&fGracias por participar en el &6evento &fsigue nuestra transmisión en\n";
    public final String urlLive = "&dtwitch.tv/minecraft_un";
    public static Boolean activatePlugin;

    public static void refreshConfig(UN_RejectPlayer plugin) {
        UNRejectPlayerEvents.activatePlugin = plugin.getConfig().getBoolean("activate");
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerJoin(PlayerJoinEvent event) {
        if (activatePlugin) {
            Player player = event.getPlayer();
            String playerNickName = player.getDisplayName();
            String playerDeaths = PlaceholderAPI.setPlaceholders(player, "%cmi_user_metaint_deaths%");

            if (playerDeaths != "") {
                float playerDeathsFloat = Float.parseFloat(playerDeaths);
                if (playerDeathsFloat != 0) {
                    player.kickPlayer(kickMsg+urlLive);
                }
            } else {
                String cmdCreatePH = "cmi usermeta " + player.getDisplayName() + " add deaths 0 -s";
                getServer().dispatchCommand(getServer().getConsoleSender(), cmdCreatePH);
            }
        }
    }

    @EventHandler (priority = EventPriority.HIGHEST)
    public void onPlayerDead(PlayerDeathEvent event) {
        if (activatePlugin) {
            Player player = event.getEntity();
            String cmdIncrementDeaths = "cmi usermeta " + player.getDisplayName() + " increment deaths +1 -s";
            getServer().dispatchCommand(getServer().getConsoleSender(), cmdIncrementDeaths);
            player.kickPlayer(kickMsg+urlLive);
        }
    }
}
