package MULE.models;

/**
 * Created by Antonia on 9/17/2015.
 */
public class Mule {
    //Started Mule class
    private Resource resource;
    public Mule() {
        this.resource = null;
    }
    public Mule(Resource resource) {
        this.resource = resource;
    }
    public Resource getResource(){
        return resource;
    }
    public boolean hasResource() {
        return resource != null;
    }
    public void setResource(Resource resource){
        this.resource = resource;
    }

}
