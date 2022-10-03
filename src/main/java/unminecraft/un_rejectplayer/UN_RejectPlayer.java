package unminecraft.un_rejectplayer;

import org.bukkit.ChatColor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import unminecraft.un_rejectplayer.commands.UNRejectPlayerCommands;
import unminecraft.un_rejectplayer.events.UNRejectPlayerEvents;

import java.util.Objects;
public final class UN_RejectPlayer extends JavaPlugin implements Listener {

    public final String headLog = "[UN_RejectPlayer]: ";

    @Override
    public void onEnable() {
        UNRejectPlayerEvents.refreshConfig(this);
        if (getServer().getPluginManager().isPluginEnabled("PlaceholderAPI")) {
            getServer().getConsoleSender().sendMessage(ChatColor.GREEN + headLog + "PlaceholderAPI hooked!");
            getServer().getPluginManager().registerEvents(new UNRejectPlayerEvents(), this);
        } else {
            throw new RuntimeException( headLog + "Could not find PlaceholderAPI!! Plugin can not work without it!");
        }

        UNRejectPlayerCommands commands = new UNRejectPlayerCommands(this);
        Objects.requireNonNull(getCommand("reloadunrp")).setExecutor(commands);
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + headLog + "Plugin is enabled!");
    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.YELLOW + headLog + "Plugin is disabled!");
    }

}
