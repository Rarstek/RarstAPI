package me.rarstman.rarstapi;

import me.rarstman.rarstapi.command.CommandManager;
import me.rarstman.rarstapi.command.impl.RarstAPICommand;
import me.rarstman.rarstapi.configuration.ConfigManager;
import me.rarstman.rarstapi.configuration.impl.RarstAPIConfig;
import me.rarstman.rarstapi.configuration.impl.RarstAPIMessages;
import me.rarstman.rarstapi.hook.HooksManager;
import me.rarstman.rarstapi.hook.impl.VaultHook;
import me.rarstman.rarstapi.logger.Logger;
import me.rarstman.rarstapi.reflection.ReflectionManager;
import me.rarstman.rarstapi.reflection.impl.CommandMapReflection;
import org.bukkit.plugin.java.JavaPlugin;

public class RarstAPIPlugin extends JavaPlugin {

    private Logger apiLogger;

    @Override
    public void onLoad() {
        this.apiLogger = new Logger(java.util.logging.Logger.getLogger("RarstAPI"));
    }

    @Override
    public void onEnable() {
        this.apiLogger.info("Registering hooks...");
        HooksManager.registerHook(new VaultHook());

        this.apiLogger.info("Registering configs...");
        ConfigManager.registerConfigs(new RarstAPIConfig(), new RarstAPIMessages());

        this.apiLogger.info("Registering reflections...");
        ReflectionManager.registerReflection(new CommandMapReflection());

        this.apiLogger.info("Registering command...");
        CommandManager.registerCommand(new RarstAPICommand());
    }

    public Logger getAPILogger() {
        return this.apiLogger;
    }

    public static RarstAPIPlugin getAPI() {
        return JavaPlugin.getPlugin(RarstAPIPlugin.class);
    }

}
