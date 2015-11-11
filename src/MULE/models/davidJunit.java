package MULE.models;

//import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by David on 11/3/2015.
 */
public class davidJunit {
    private ResourceStore invent = new ResourceStore();
    private static final int TIMEOUT = 200;

//    @Before {
//    }

    @Test(timeout = TIMEOUT)
    public void testBuyFood() {
        invent.buyFood();
        assertEquals(15, invent.getFoodInventory());
        invent.buyFood();
        invent.buyFood();
        invent.buyFood();
        invent.buyFood();
        invent.buyFood();
        invent.buyFood();
        invent.buyFood();
        invent.buyFood();
        invent.buyFood();
        invent.buyFood();
        invent.buyFood();
        invent.buyFood();
        invent.buyFood();
        invent.buyFood();
        invent.buyFood();
        assertEquals(0, invent.getFoodInventory());
        invent.buyFood();
        assertEquals(0, invent.getFoodInventory());
    }

}
