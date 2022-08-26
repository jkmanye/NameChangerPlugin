package xyz.devmeko.MCPlugin.NameChanger.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import xyz.devmeko.MCPlugin.NameChanger.ChangeName;

public class ChangeCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (sender instanceof Player) {
            if (args.length == 1) {
                try {
                    ChangeName.changeName(args[0], (Player) sender);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return true;
    }
}