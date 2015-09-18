package MULE.models;

/**
 * Created by Antonia on 9/16/2015.
 */
public class Land {
    //Just starting MULE.models.Land with basic info
    private Player owner = null;
    private String type;
    private String resource;
    private int price;

    public Land(String type) {
        this.type = type;
    }
    public boolean isOwned() {
        return this.owner != null;
    }
    public void setOwner(Player p) {
        this.owner = p;
    }
    public boolean hasResource() {
        return this.resource != null;
    }
    public void setResource(String res) {
        this.resource = res;
    }
    public void setLandType(String type) {
        this.type = type;
    }
    public String getResource() {
    return this.resource;
    }
    public Player getOwner() {
        return this.owner;
    }
    //not sure what to do about values yet also gonna look into making land type an enum
}
