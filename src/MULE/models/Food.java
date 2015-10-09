package MULE.models;

/**
 * Created by Antonia on 10/2/2015.
 */
public class Food extends Resource {


    public Food() {
        this.price = 30;
        this.storePriceExtra = 25;
    }

    @Override
    public int sellInventory(ResourceStore store) {
        store.addFood();
        return store.getFoodInventory();
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public int getInventory(ResourceStore store) {
        return store.getFoodInventory();
    }

    @Override
    public int buyInventory(ResourceStore store) {
        store.buyFood();
        return store.getFoodInventory();
    }
}
