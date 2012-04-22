/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.windwarrior.bukkit.tweakstats;

import com.avaje.ebean.validation.Length;
import com.avaje.ebean.validation.NotNull;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author lennart
 */
@Entity()
@Table(name = "tweakdeaths")
public class TweakDeath {

    @Id
    private int id;
    @Length(max = 32)
    @NotNull
    private String playername;
    @Length(max = 32)
    @NotNull
    private String world;
    @Length(max = 32)
    @NotNull
    private String deathcause;
    @NotNull
    private double x;
    @NotNull
    private double y;
    @NotNull
    private double z;
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date datetime;
    @Length(max = 32)
    private String otherentity;

    public TweakDeath() {
        //Default constructor for persistence manager
    }

    public TweakDeath(String playername, String world, String deathcause, double x, double y, double z, Date datetime, String otherentity) {
        this.playername = playername;
        this.world = world;
        this.deathcause = deathcause;
        this.x = x;
        this.y = y;
        this.z = z;
        this.datetime = datetime;
        this.otherentity = otherentity;
    }

    public Date getDatetime() {
        return datetime;
    }

    public String getDeathcause() {
        return deathcause;
    }

    public int getId() {
        return id;
    }

    public String getOtherentity() {
        return otherentity;
    }

    public String getPlayername() {
        return playername;
    }

    public String getWorld() {
        return world;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public void setDeathcause(String deathcause) {
        this.deathcause = deathcause;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setOtherentity(String otherentity) {
        this.otherentity = otherentity;
    }

    public void setPlayername(String playername) {
        this.playername = playername;
    }

    public void setWorld(String world) {
        this.world = world;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setZ(double z) {
        this.z = z;
    }
}
