package MULE.models;

/**
 * Created by Antonia on 10/23/2015.
 */
public class EventTwo implements RandomEvent {
    public EventTwo(){}
    @Override
    public String apply( Player p) {
            p.addResource(new SmithOre());
            p.addResource(new SmithOre());
            return p.getName() + " A WANDERING TECH STUDENT REPAID YOUR HOSPITALITY BY LEAVING TWO BARS OF ORE.";
    }
}
