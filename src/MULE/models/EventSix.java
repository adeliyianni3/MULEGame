package MULE.models;

/**
 * Created by Antonia on 10/23/2015.
 */
public class EventSix implements RandomEvent {
    @Override
    public String apply(Player p) {
        int i = p.getFood();
        for (int k = 0; k < i/2; k = k + 1) {
            p.removeResource(new Food());
        }
        return p.getName() + " MISCHIEVOUS UGA STUDENTS BROKE INTO YOUR STORAGE SHED AND STOLE HALF YOUR FOOD.";
    }
}
