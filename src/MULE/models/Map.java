package MULE.models;

// Created by Lauren on 9/16/2015.

/**
 * Map that creates, holds, and finds the Land tile information.
 */
public class Map {

    /**
     * Array of Land objects.
     */
    private final Land[][] landArray = new Land[5][9];

    /**
     * No-args constructor.
     */
    public Map() {
        for (int row = 0; row < 5; row++) {
            landArray[row][4] = new Land(new River(), row, 4);
            for (int col = 0; col < 4; col++) {
                landArray[row][col] = new Land(new Plain(), row, col);
                landArray[row][8 - col] =
                        new Land(new Plain(), row, 8 - col);
            }
        }
        landArray[0][2] = new Land(new Mountain(), 0, 2);
        landArray[1][1] = new Land(new Mountain(), 1, 1);
        landArray[2][8] = new Land(new Mountain(), 2, 8);

        landArray[3][1] = new Land(new D_Mountain(), 3, 1);
        landArray[4][2] = new Land(new D_Mountain(), 4, 2);
        landArray[3][6] = new Land(new D_Mountain(), 3, 6);
        landArray[4][8] = new Land(new D_Mountain(), 4, 8);

        landArray[2][0] = new Land(new T_Mountain(), 2, 0);
        landArray[0][6] = new Land(new T_Mountain(), 0, 6);
        landArray[1][8] = new Land(new T_Mountain(), 1, 8);
    }

    /**
     * Finds the Land object of the associated position.
     * @param row Row index to be checked
     * @param col Column index to be checked
     * @return Land at the given location
     */
    public final Land whatLand(final int row, final int col) {
        return landArray[row][col];
    }

    /**
     * Checks if the given position is the town tile.
     * @param row Row index to be checked
     * @param col Column index to be checked
     * @return true if the town is located at the given position,
     *  false otherwise
     */
    public final boolean isTown(final int row, final int col) {
        int townRow = 2;
        int townCol = 4;
        return (row == townRow && col == townCol);
    }

}
