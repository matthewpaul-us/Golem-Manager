/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.mpaul0416.GolemManager;

import java.util.Random;
import org.bukkit.entity.IronGolem;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.plugin.Plugin;

/**
 *
 * @author Matthew Paul <mpaul0416@gmail.com>
 */
public class GolemListener implements Listener {
    private Plugin plugin;
    
    private final Random random;
    
    static final String[] names = {
        "Harold", "George", "John",
        "Randy", "Joe"
    };
    
    @EventHandler
    public void onRightClickGolem(PlayerInteractEntityEvent event)
    {
        Player player = event.getPlayer();
        
        if (event.getRightClicked() instanceof IronGolem)
        {
            IronGolem golem = (IronGolem) event.getRightClicked();
            
            if(golem.hasMetadata("name"))
            {
                player.sendMessage("Hi, my name is " + golem.getMetadata("name").get(0).asString() + ".");
            }
            else
            {
                player.sendMessage("Do you know my name? I've forgotten it...");
            }
        }
    }
    
    @EventHandler
    public void onSpawnGolem(CreatureSpawnEvent event)
    {
        if(event.getSpawnReason() == CreatureSpawnEvent.SpawnReason.BUILD_IRONGOLEM)
        {
            IronGolem golem = (IronGolem) event.getEntity();
            
            golem.setMetadata("name", new FixedMetadataValue(plugin, getRandomName()));
        }
    }

    public GolemListener(Plugin plugin) {
        this.plugin = plugin;
        random = new Random();
    }
    
    private String getRandomName()
    {
        return names[random.nextInt(names.length)];
    }
}
