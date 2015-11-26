package MULE.models;

import MULE.controllers.Game;

/**
 * Created by Antonia on 11/26/2015.
 */
public class PlanetaryEventOne implements RandomEvent {

    @Override
    public String apply(Player p) {
        for (Player pl: Game.getInstance().getPlayers()) {
            if(pl.getFood() > 0) {
                for (int x = 0; x < pl.getFood(); x++) {
                    pl.removeResource(new Food());
                }
            }
        }
        return "ACID RAIN DESTROYS ALL SILOS, HALF THE FOOD IS LOST.";
    }
}
