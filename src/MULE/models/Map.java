package MULE.models;

// Created by Lauren on 9/16/2015.

/**
 * Map that creates, holds, and finds the Land tile information.
 */
public class Map {
    /**
     * Row index of the town tile.
     */
    private final int townRow = 2; //not local so as to avoid magic numbers
    /**
     * Column index of the town tile.
     */
    private final int townCol = 4; //not local so as to avoid magic numbers

    /**
     * Array of Land objects.
     */
    private final Land[][] landArray = new Land[5][9];

    /**
     * No-args constructor.
     */
    public Map() {
        for (int row = 0; row < 5; row++) {
            landArray[row][4] = new Land(LandType.RIVER, row, 4);
            for (int col = 0; col < 4; col++) {
                landArray[row][col] = new Land(LandType.PLAIN, row, col);
                landArray[row][8 - col] =
                        new Land(LandType.PLAIN, row, 8 - col);
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
        return (row == townRow && col == townCol);
    }

}
