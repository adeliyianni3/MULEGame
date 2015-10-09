package MULE.models;

/**
 * Created by Antonia on 10/2/2015.
 */
public class SmithOre implements Resource {

    private int price;

    public SmithOre() {
        this.price = 50;
    }
    @Override
    public int sellInventory(ResourceStore store) {
        store.addSmithOre();
        return store.getSmithOreInventory();
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public int getInventory(ResourceStore store) {
        return store.getSmithOreInventory();
    }

    @Override
    public int buyInventory(ResourceStore store) {
        store.buySmithOre();
        return store.getSmithOreInventory();
    }
}
