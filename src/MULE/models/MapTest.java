package MULE.models;

import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
/**
 * Created by Lauren on 11/1/2015.
 */
public class MapTest {

    @Test
    public void mapTown(){
        Map myMap = new Map();
        assertTrue(myMap.isTown(2, 4));
        for (int row = 0; row<5; row++) {
            assertFalse(myMap.isTown(row, 0));
            assertFalse(myMap.isTown(row, 1));
            assertFalse(myMap.isTown(row, 2));
            assertFalse(myMap.isTown(row, 3));

            assertFalse(myMap.isTown(row, 5));
            assertFalse(myMap.isTown(row, 6));
            assertFalse(myMap.isTown(row, 7));
            assertFalse(myMap.isTown(row, 8));
        }

        for (int col = 0; col<9; col++){
            assertFalse(myMap.isTown(0,col));
            assertFalse(myMap.isTown(1,col));

            assertFalse(myMap.isTown(3,col));
            assertFalse(myMap.isTown(4,col));
        }

    }


}