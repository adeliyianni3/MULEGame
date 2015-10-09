package MULE.models;

//Created by TEAM on 9/22/2015.
public abstract class Resource {
    private int price;

    public Resource() {

    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int p) {
        price = p;
    }

    public abstract int getInventory(ResourceStore store);

    public abstract int buyInventory(ResourceStore store);

    public abstract int sellInventory(ResourceStore store);
}
