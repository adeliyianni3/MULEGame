package MULE.models;

import MULE.controllers.Game;

/**
 * Created by Antonia on 10/23/2015.
 */
public class EventFive implements RandomEvent {
    public EventFive(){}
    private static int[] roundsM = {25, 25, 25, 50, 50, 50, 50, 75, 75, 75, 75, 100};
    @Override
    public String apply(Player p) {
            int m = roundsM[Game.instance.getRound() - 3];
            int lose = 4*m;
            p.subtractMoney(lose);
            return p.getName() + " FLYING CAT-BUGS ATE THE ROOF OFF YOUR HOUSE. REPAIRS COST $" + lose;
    }
}
