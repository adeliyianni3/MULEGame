package MULE.models;

// Created by Lauren on 9/16/2015.

public class Map {

    private Land[][] landArray = new Land[5][9];
    public Map() {
        for (int row=0; row<5; row++) {
            landArray[row][4] = new Land(LandType.RIVER, row, 4);
            for (int col = 0; col < 4; col++) {
                landArray[row][col] = new Land(LandType.PLAIN, row, col);
                landArray[row][8-col] = new Land(LandType.PLAIN, row, 8-col);
            }
        }
        landArray[0][2] = new Land(LandType.MOUNTAIN, 0, 2);
        landArray[1][1] = new Land(LandType.MOUNTAIN, 1, 1);
        landArray[2][8] = new Land(LandType.MOUNTAIN, 2, 8);

        landArray[3][1] = new Land(LandType.D_MOUNTAIN, 3, 1);
        landArray[4][2] = new Land(LandType.D_MOUNTAIN, 4, 2);
        landArray[3][6] = new Land(LandType.D_MOUNTAIN, 3, 6);
        landArray[4][8] = new Land(LandType.D_MOUNTAIN, 4, 8);

        landArray[2][0] = new Land(LandType.T_MOUNTAIN, 2, 0);
        landArray[0][6] = new Land(LandType.T_MOUNTAIN, 0, 6);
        landArray[1][8] = new Land(LandType.T_MOUNTAIN, 1, 8);
    }

    public Land whatLand(int row, int col){
        return landArray[row][col];
    }

    public boolean isTown(int row, int col){
        return (row == 2 && col == 4);
    }

}
