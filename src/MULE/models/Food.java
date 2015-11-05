package MULE.models;

// Created by Antonia on 10/2/2015.
public class Food extends Resource {


    public Food() {
        this.price = 30;
        this.storePriceExtra = 25;
        this.id = 1;
    }

    @Override
    public void sellInventory(ResourceStore store) {
        store.addFood();
        //return store.getFoodInventory();
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

    @Override
    public String toString() {
        return "Food";
    }

    @Override
    public int produce(LandType type) {
        return (int)type.getFoodFactor();
    }
}
