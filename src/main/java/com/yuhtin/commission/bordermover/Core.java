package com.yuhtin.commission.bordermover;

import com.yuhtin.commission.bordermover.manager.BorderManager;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
public class Core extends JavaPlugin {

    private final BorderManager borderManager = new BorderManager();

    @Override
    public void onEnable() {
        saveDefaultConfig();
        borderManager.load();

        getLogger().info("Plugin enabled");
    }

    public static Core getInstance() {
        return getPlugin(Core.class);
    }
}
