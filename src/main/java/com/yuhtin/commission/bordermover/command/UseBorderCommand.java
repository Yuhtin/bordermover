package com.yuhtin.commission.bordermover.command;

import com.yuhtin.commission.bordermover.Core;
import lombok.val;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class UseBorderCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        val plugin = Core.getInstance();
        val borderManager = plugin.getBorderManager();
        if (args.length > 0 && args[0].equalsIgnoreCase("reload")) {
            plugin.reloadConfig();
            borderManager.load();
            return false;
        }

        borderManager.processBorders();

        sender.sendMessage("§aIniciando alterações nas bordas.");
        return false;
    }
}
