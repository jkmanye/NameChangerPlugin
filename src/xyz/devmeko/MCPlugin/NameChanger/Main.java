package xyz.devmeko.MCPlugin.NameChanger;

import org.bukkit.plugin.java.JavaPlugin;
import xyz.devmeko.MCPlugin.NameChanger.Commands.ChangeCommand;
import xyz.devmeko.MCPlugin.NameChanger.Commands.RevertCommand;

public class Main extends JavaPlugin {

    @Override
    public void onDisable() {
        super.onDisable();
    }

    @Override
    public void onEnable() {
        super.onEnable();
        getCommand("nick").setExecutor(new ChangeCommand());
        getCommand("revert").setExecutor(new RevertCommand());
    }
}
