package MULE.models;

import MULE.controllers.Game;

//Created by Antonia on 10/23/2015.
public class EventFour implements RandomEvent {
    public EventFour(){}
    private static int[] roundsM = {25, 25, 25, 50, 50, 50, 50, 75, 75, 75, 75, 100};
    @Override
    public String apply(Player p) {
            int m = roundsM[Game.instance.getRound() - 3];
            int gain = 2*m;
            p.addMoney(gain);
            return p.getName() + " YOU FOUND A DEAD MOOSE RAT AND SOLD THE HIDE FOR $" + gain;

    }
}
