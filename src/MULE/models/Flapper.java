package MULE.models;

//Created by Antonia on 11/4/2015.

/**
 * Interface containing information based of a Race's characteristics.
 */
public class Flapper implements Race {
    /**
     * Starting amount of money.
     */
    private final int startMoney = 1600;
    /**
     * No-args constructor.
     */
    public Flapper() {}
    /**
     * Gets the starting amount of money.
     * @return The starting amount of money
     */
    @Override
    public final int startMoney() {
        return startMoney;
    }
}
