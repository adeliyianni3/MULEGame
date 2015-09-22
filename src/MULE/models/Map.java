package MULE.models;

/**
 * Created by Lauren on 9/16/2015.
 */

public class Map {

    private Land[][] landArray = new Land[5][9];
    public Map() {
        for (int row=0; row<5; row++) {
            landArray[row][4] = new Land(LandType.RIVER);
            for (int col = 0; col < 4; col++) {
                landArray[row][col] = new Land(LandType.PLAIN);
                landArray[row][8-col] = new Land(LandType.PLAIN);
            }
        }
        landArray[0][2] = new Land(LandType.MOUNTAIN);
        landArray[1][1] = new Land(LandType.MOUNTAIN);
        landArray[2][8] = new Land(LandType.MOUNTAIN);

        landArray[3][1] = new Land(LandType.D_MOUNTAIN);
        landArray[4][2] = new Land(LandType.D_MOUNTAIN);
        landArray[3][6] = new Land(LandType.D_MOUNTAIN);
        landArray[4][8] = new Land(LandType.D_MOUNTAIN);

        landArray[2][0] = new Land(LandType.T_MOUNTAIN);
        landArray[0][6] = new Land(LandType.T_MOUNTAIN);
        landArray[1][8] = new Land(LandType.T_MOUNTAIN);
    }

    public Land whatLand(int row, int col){
        return landArray[row][col];
    }

    public boolean isTown(int row, int col){
        if (row==2 && col==4){
            return true;
        }
        return false;
    }

}
