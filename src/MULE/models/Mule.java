package MULE.models;

/**
 * Created by Antonia on 9/17/2015.
 */
public class Mule {
    //Started Mule class
    private String resourceIs;
    public Mule() {
        this.resourceIs = null;
    }
    public String getResource(){
        return resourceIs;
    }
    public boolean hasResource() {
        return resourceIs != null;
    }
}
