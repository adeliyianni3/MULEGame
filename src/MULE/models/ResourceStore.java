package MULE.models;

//Created by Antonia on 9/26/2015.
public class ResourceStore {
    private int energyInventory = 16;
    private int crystiteInventory = 0;
    private int foodInventory = 16;
    private int smithoreInventory = 0;
    private int muleInventory = 25;

    public int getEnergyInventory() {
        return energyInventory;
    }
    public void buyEnergy() {
        int total = getEnergyInventory();
        if (total > 0) {
            energyInventory = total - 1;
        }
    }
    public void addEnergy() {
        energyInventory = energyInventory + 1;
    }

    public int getFoodInventory() {
        return foodInventory;
    }
    public void buyFood() {
        int total = getFoodInventory();
        if (total > 0) {
            foodInventory = total - 1;
        }
    }
    public void addFood() {
        foodInventory = foodInventory + 1;
    }

    public int getCrystiteInventory() {
        return crystiteInventory;
    }
    public void buyCrystite() {
        int total = getCrystiteInventory();
        if (total > 0) {
            crystiteInventory = total - 1;
        }
    }
    public void addCrystite() {
        crystiteInventory = crystiteInventory + 1;
    }

    public int getMuleInventory() {
        return muleInventory;
    }
    public void buyMule() {
        int total = getMuleInventory();
        if (total > 0) {
            muleInventory = total - 1;
        }
    }
   public void addMule() {
       muleInventory = muleInventory + 1;
   }

    public int getSmithOreInventory() {
        return smithoreInventory;
    }
    public void buySmithOre() {
        int total = getSmithOreInventory();
        if (total > 0) {
            smithoreInventory = total - 1;
        }
    }
    public void addSmithOre() {
        smithoreInventory = smithoreInventory + 1;
    }
}
