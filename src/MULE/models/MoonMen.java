package MULE.models;

/**
 * Created by Antonia on 11/26/2015.
 */
public class MoonMen implements Race {
    /**
     * Starting amount of money.
     */
    private final int startMoney = 800;
    /**
     * No-args constructor.
     */
    public MoonMen() { }
    /**
     * Gets the starting amount of money.
     * @return The starting amount of money
     */
    @Override
    public int startMoney() {
        return startMoney;
    }
}
