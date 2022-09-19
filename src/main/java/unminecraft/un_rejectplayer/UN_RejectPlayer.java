package unminecraft.un_rejectplayer;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import unminecraft.un_rejectplayer.commands.UNRejectPlayerCommands;
import unminecraft.un_rejectplayer.events.UNRejectPlayerEvents;

public final class UN_RejectPlayer extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        UNRejectPlayerCommands commands = new UNRejectPlayerCommands();
        getServer().getPluginManager().registerEvents(new UNRejectPlayerEvents(), this);
        getCommand("saludo").setExecutor(commands);
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[UN_RejectPlayer]: Plugin is enabled!");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getServer().getConsoleSender().sendMessage(ChatColor.YELLOW + "[UN_RejectPlayer]: Plugin is disabled!");
    }
}
