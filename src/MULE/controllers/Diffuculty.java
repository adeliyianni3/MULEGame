package MULE.controllers;

/**
 * Created by Antonia on 11/27/2015.
 */
public enum Diffuculty {
    BEGINNER(8, 4, 16, 16, 0, 0, 25),
    STANDARD(4, 2, 8, 8, 8, 0, 14),
    TOURNAMENT(4, 2, 8, 8, 8, 0, 14);

    private int playerFood;
    private int playerEnergy;
    private int storeFood;
    private int storeEnergy;
    private int storeSmithOre;
    private int storeCrystite;
    private int storeMule;
    Diffuculty(int pFood, int pEnergy, int sFood, int sEnergy,
               int sSmithOre, int sCrystite, int sMule) {
        playerFood = pFood;
        playerEnergy = pEnergy;
        storeFood = sFood;
        storeEnergy = sEnergy;
        storeSmithOre = sSmithOre;
        storeCrystite = sCrystite;
        storeMule = sMule;

    }

    public int getPlayerEnergy() {
        return playerEnergy;
    }

    public int getPlayerFood() {
        return playerFood;
    }

    public int getStoreCrystite() {
        return storeCrystite;
    }

    public int getStoreEnergy() {
        return storeEnergy;
    }

    public int getStoreFood() {
        return storeFood;
    }

    public int getStoreMule() {
        return storeMule;
    }

    public int getStoreSmithOre() {
        return storeSmithOre;
    }
}
