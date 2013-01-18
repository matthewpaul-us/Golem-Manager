/*
 * CommandExecutor.java
 * Project: GolemManager
 * 
 * Programmed by: Matthew Paul <mpaul0416@gmail.com>
 * Date created: Jan 15, 2013
 * Last modified by: Matthew Paul <mpaul0416@gmail.com>
 * 
 * TODO Add a meaningful file header
 */

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gmail.mpaul0416.GolemManager;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;

/**
 *
 * @author Matthew Paul <mpaul0416@gmail.com>
 */
public class CommandExecutor implements TabExecutor {
    
    String[] commands = {
        "list",
        "one",
        "two",
        "three"
    };
    
    ArrayList<String> commandList;

    public CommandExecutor() {
        this.commandList = new ArrayList<String>();
        
        for (String string : commands) {
            commandList.add(string);
        }
    }

    @Override
    public List<String> onTabComplete(CommandSender cs, Command cmnd, String string, String[] strings) {
        ArrayList<String> returnList = new ArrayList<>();
        
        for (String command : commandList) {
            if (command.startsWith(strings[strings.length - 1])) {
                returnList.add(command);
            }
        }
        
        return returnList;
    }

    @Override
    public boolean onCommand(CommandSender cs, Command cmnd, String string, String[] strings) {
        if (cmnd.getName().equalsIgnoreCase("list")) {
            cs.sendMessage("You want a list of the golems!");
            return true;
        }
        else {
            return false;
        }
        
    }

}
