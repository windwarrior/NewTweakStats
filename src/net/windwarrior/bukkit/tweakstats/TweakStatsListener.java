/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.windwarrior.bukkit.tweakstats;

import java.util.Date;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.PlayerDeathEvent;

/**
 *
 * @author lennart
 */
public class TweakStatsListener implements Listener {

    private final TweakStats ts;

    public TweakStatsListener(TweakStats ts) {
        this.ts = ts;
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent pde) {
        Player entity = (Player) pde.getEntity();
        EntityDamageEvent lastDamageCause = entity.getLastDamageCause();
        DamageCause dc = lastDamageCause.getCause();
        String otherentity = null;
        if (lastDamageCause instanceof EntityDamageByEntityEvent) {
            EntityDamageByEntityEvent edb = (EntityDamageByEntityEvent) lastDamageCause;
            Entity damager = edb.getDamager();
            if (damager instanceof Player) {
                Player pl = (Player) damager;
                otherentity = pl.getDisplayName();
            } else {
                otherentity = damager.getType().getName();
            }

        }

        ts.getDatabase().insert(new TweakDeath(
                entity.getName(),
                entity.getLocation().getWorld().getName(),
                dc.toString(), entity.getLocation().getX(),
                entity.getLocation().getY(),
                entity.getLocation().getZ(),
                new Date(System.currentTimeMillis()),
                otherentity));


    }
}
