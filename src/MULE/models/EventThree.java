package MULE.models;

import MULE.controllers.Game;

import java.awt.*;

/**
 * Created by Antonia on 10/23/2015.
 */
public class EventThree implements RandomEvent {
    private static int[] roundsM = {25, 25, 25, 50, 50, 50, 50, 75, 75, 75, 75, 100};
    public EventThree(){}
    @Override
    public String apply(Player p) {
            int m = roundsM[Game.instance.getRound() - 3];
            int gain = 8*m;
            p.addMoney(gain);
            return p.getName() + " THE MUSEUM BOUGHT YOUR ANTIQUE PERSONAL COMPUTER FOR $" + gain;
    }
}
