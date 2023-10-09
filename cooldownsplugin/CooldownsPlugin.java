package me.ilgroggo.cooldownsplugin;

import me.ilgroggo.cooldownsplugin.commands.HealCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class CooldownsPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic

        getCommand("heal").setExecutor(new HealCommand());

    }
}
