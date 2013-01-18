/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.mpaul0416.GolemManager;

import java.util.logging.Handler;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @author Matthew Paul <mpaul0416@gmail.com>
 */
public class GolemManager extends JavaPlugin {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        return super.onCommand(sender, command, label, args); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void onDisable() {
        HandlerList.unregisterAll(this);
    }

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new GolemListener(this), this);
        getCommand("list").setExecutor(new CommandExecutor());
    }
    
}
