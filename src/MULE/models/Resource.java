package MULE.models;

//Created by TEAM on 9/22/2015.
public abstract class Resource {
    int price = 0;
    int storePriceExtra = 0;
    int id = 0;

    public Resource() {

    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int p) {
        price = p;
    }

    public int getStorePriceExtra() {
        return storePriceExtra;
    }

    public int getID() {
        return id;
    }

    public abstract int getInventory(ResourceStore store);

    public abstract int buyInventory(ResourceStore store);

    public abstract int sellInventory(ResourceStore store);

    public abstract int produce(LandType type);
}
