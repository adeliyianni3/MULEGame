package MULE.models;

/**
 * Created by Antonia on 10/2/2015.
 */
public class Crystite extends Resource {

    public Crystite() {
        this.price = 100;
        this.storePriceExtra = 100;
    }

    @Override
    public int sellInventory(ResourceStore store) {
        store.addCrystite();
        return store.getCrystiteInventory();
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public int getInventory(ResourceStore store) {
        return store.getCrystiteInventory();
    }

    @Override
    public int buyInventory(ResourceStore store) {
        store.buyCrystite();
        return store.getCrystiteInventory();
    }
    @Override
    public String toString() {
        return "Crystite";
    }
}
