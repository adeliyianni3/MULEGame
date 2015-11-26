package MULE.models;

import MULE.controllers.Game;

/**
 * Created by Antonia on 11/26/2015.
 */
public class PlanetaryEventThree implements RandomEvent {

    @Override
    public String apply(Player p) {
        for (Player pl: Game.getInstance().getPlayers()) {
            if(pl.getSmithore() > 0) {
                for (int x = 0; x < pl.getSmithore(); x++) {
                    pl.removeResource(new SmithOre());
                }
            }
        }
        Game.getInstance().getStore().clearSmithOreStock();
        return "PIRATES RAID AND STEAL ALL THE SMITHORE IN THE COLONY.";
    }
}
