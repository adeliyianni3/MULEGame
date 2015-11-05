package MULE.models;

// Created by Antonia on 10/2/2015.
public class SmithOre extends Resource {

    public SmithOre() {
        this.price = 50;
        this.storePriceExtra = 75;
        this.id = 2;
    }

    @Override
    public void sellInventory(ResourceStore store) {
        store.addSmithOre();
        //return store.getSmithOreInventory();
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

    @Override
    public String toString() {
        return "SmithOre";
    }

    @Override
    public int produce(LandType type) {
        return (int)type.getSmithOreFactor();
    }
}
