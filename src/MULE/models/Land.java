package MULE.models;
import java.util.Random;

/**
 * Created by Antonia on 9/16/2015.
 */
public class Land {
    //Just starting MULE.models.Land with basic info
    private Player owner = null;
    private String type;
    private Mule mule;

    public Land(String type) {
        this.type = type;
    }
    public boolean isOwned() {
        return this.owner != null;
    }
    public void setOwner(Player p) {
        this.owner = p;
    }
    public boolean hasMule() {
        return this.mule != null;
    }
    public void setMule(Mule newMule) {
        this.mule = newMule;
    }
    public void setLandType(String type) {
        this.type = type;
    }
    public Mule getMule() {
    return this.mule;
    }
    public Player getOwner() {
        return this.owner;
    }
    //not sure what to do about values yet also gonna look into making land type an enum
}
