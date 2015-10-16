package MULE.models;

/**
 * Created by Antonia on 10/2/2015.
 */
public class Energy extends Resource {


    public Energy() {
        this.price = 25;
        this.storePriceExtra = 50;
    }

    @Override
    public int sellInventory(ResourceStore store) {
        store.addEnergy();
        return store.getEnergyInventory();
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public int getInventory(ResourceStore store) {
        return store.getEnergyInventory();
    }

    @Override
    public int buyInventory(ResourceStore store) {
        store.buyEnergy();
        return store.getEnergyInventory();
    }

    @Override
    public String toString() {
        return "Energy";
    }
}
