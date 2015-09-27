package MULE.models;

//Created by Aaron on 9/22/2015.
public enum Resource {
    //Just put values for beginner lvl not tournament
    ENERGY(25),
    FOOD(30),
    SMITH_ORE(50),
    MULE(100),
    CRYSTITE(100);
    private int price;

    Resource(int price) {
        this.price = price;
    }
    public int getPrice() {
        return price;
    }

    public int getInventory(ResourceStore store) {
        if (equals(ENERGY)) {
            return store.getEnergyInventory();
        }
        if (equals(FOOD)) {
            return store.getFoodInventory();
        }
        if (equals(MULE)) {
            return store.getMuleInventory();
        }
        if (equals(SMITH_ORE)) {
            return store.getSmithOreInventory();
        }
        if (equals(CRYSTITE)) {
            return store.getCrystiteInventory();
        }
        return 0;
    }
    public int buyInventory(ResourceStore store) {
        if (equals(ENERGY)) {
            store.buyEnergy();
            return store.getEnergyInventory();
        }
        if (equals(FOOD)) {
            store.buyFood();
            return store.getFoodInventory();
        }
        if (equals(MULE)) {
            store.buyMule();
            return store.getMuleInventory();
        }
        if (equals(SMITH_ORE)) {
            store.buySmithOre();
            return store.getSmithOreInventory();
        }
        if (equals(CRYSTITE)) {
            store.buyCrystite();
            return store.getCrystiteInventory();
        }
        return 0;
    }
    public int sellInventory(ResourceStore store) {
        if (equals(ENERGY)) {
            store.addEnergy();
            return store.getEnergyInventory();
        }
        if (equals(FOOD)) {
            store.addFood();
            return store.getFoodInventory();
        }
        if (equals(SMITH_ORE)) {
            store.addSmithOre();
            return store.getSmithOreInventory();
        }
        if (equals(CRYSTITE)) {
            store.addCrystite();
            return store.getCrystiteInventory();
        }
        if (equals(MULE)) {
            store.addMule();
            return store.getMuleInventory();
        }
        return 0;
    }
}
