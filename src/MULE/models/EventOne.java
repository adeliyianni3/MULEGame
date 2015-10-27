package MULE.models;

/**
 * Created by Antonia on 10/23/2015.
 */
public class EventOne implements RandomEvent {

    @Override
    public String apply(Player p) {
            p.addResource(new Food());
            p.addResource(new Food());
            p.addResource(new Food());
            p.addResource(new Energy());
            p.addResource(new Energy());
            return p.getName() + " YOU JUST RECEIVED A PACKAGE FROM THE GT ALUMNI CONTAINING 3 FOOD AND 2 ENERGY UNITS.";
    }
}
