package unminecraft.un_rejectplayer;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import unminecraft.un_rejectplayer.commands.UNRejectPlayerCommands;
import unminecraft.un_rejectplayer.events.UNRejectPlayerEvents;

public final class UN_RejectPlayer extends JavaPlugin implements Listener {

    public final String headLog = "[UN_RejectPlayer]: ";

    @Override
    public void onEnable() {

        if (Bukkit.getPluginManager().isPluginEnabled("PlaceholderAPI")) {
            Bukkit.getPluginManager().registerEvents(this, this);
            getServer().getConsoleSender().sendMessage(ChatColor.GREEN + headLog + "PlaceholderAPI hooked!");
        } else {
            throw new RuntimeException( headLog + "Could not find PlaceholderAPI!! Plugin can not work without it!");
        }

        UNRejectPlayerCommands commands = new UNRejectPlayerCommands();
        getServer().getPluginManager().registerEvents(new UNRejectPlayerEvents(), this);
        getCommand("saludo").setExecutor(commands);
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + headLog + "Plugin is enabled!");
    }

    @EventHandler (priority = EventPriority.HIGHEST)
    public void onJoin(PlayerJoinEvent event) {
        String playerNickName = event.getPlayer().getDisplayName();
        String playerDeaths = PlaceholderAPI.setPlaceholders(event.getPlayer(), "%cmi_user_metaint_deaths%");
        String deathsMsg = ChatColor.RED + headLog + playerNickName + " has died " + playerDeaths + " times.";
        getServer().getConsoleSender().sendMessage(deathsMsg);

        //String withoutPlaceholdersSet = playerNickName + " has died %cmi_user_metaint_deaths% times.";
        //String withPlaceholdersSet = PlaceholderAPI.setPlaceholders(event.getPlayer(), withoutPlaceholdersSet);
        event.setJoinMessage(deathsMsg);
    }


    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getServer().getConsoleSender().sendMessage(ChatColor.YELLOW + headLog + "Plugin is disabled!");
    }
}
