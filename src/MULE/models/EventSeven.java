package MULE.models;

import MULE.controllers.Game;

/**
 * Created by Antonia on 10/23/2015.
 */
public class EventSeven implements RandomEvent {
    public EventSeven(){}
    private static int[] roundsM = {25, 25, 25, 50, 50, 50, 50, 75, 75, 75, 75, 100};
    @Override
    public String apply(Player p) {
            int m = roundsM[Game.instance.getRound() - 3];
            int lose = 6*m;
            p.subtractMoney(lose);
            return p.getName() + " YOUR SPACE GYPSY INLAWS MADE A MESS OF THE TOWN. IT COST YOU " + lose + " TO CLEAN IT UP.";
    }
}
