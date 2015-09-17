/**
 * Created by Lauren on 9/16/2015.
 */

public class GameMap {

    private Land[][] landArray = new Land[5][9];
    public GameMap() {
        for (int row=0; row<5; row++) {
            landArray[row][4] = new Land("river");
            for (int col = 0; col < 4; col++) {
                landArray[row][col] = new Land("plain");
                landArray[row][8-col] = new Land("plain");
            }
        }
        landArray[0][2] = new Land("m1");
        landArray[1][1] = new Land("m1");
        landArray[2][8] = new Land("m1");

        landArray[3][1] = new Land("m2");
        landArray[4][2] = new Land("m2");
        landArray[3][6] = new Land("m2");
        landArray[4][8] = new Land("m2");

        landArray[2][0] = new Land("m3");
        landArray[0][6] = new Land("m3");
        landArray[1][8] = new Land("m3");
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
