/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.windwarrior.bukkit.tweakstats;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.PersistenceException;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @author lennart
 */
public class TweakStats extends JavaPlugin {


    @Override
    public void onEnable() {
        this.getLogger().info("[TweakStats] Enabling TweakStats!");
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new TweakStatsListener(this), this);

        try {
            this.getDatabase().find(TweakDeath.class);
        } catch (PersistenceException pe) {
            this.getLogger().severe("[TweakStats] not able to find database table, shutting down");
            this.getPluginLoader().disablePlugin(this);
        }

    }

    @Override
    public List<Class<?>> getDatabaseClasses() {
        List<Class<?>> list = new ArrayList<Class<?>>();
        list.add(TweakDeath.class);
        return list;
    }
}
