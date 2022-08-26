package xyz.devmeko.MCPlugin.NameChanger.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import xyz.devmeko.MCPlugin.NameChanger.ChangeName;

public class RevertCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (sender instanceof Player) {
            try {
                ChangeName.revert((Player) sender);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return true;
    }
}
