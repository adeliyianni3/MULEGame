package MULE.models;

/**
 * Created by Antonia on 11/4/2015.
 */
public class Bonzoid implements Race {
    private int startMoney;
    public Bonzoid() {
        startMoney = 1000;
    }

    @Override
    public int startMoney() {
        return startMoney;
    }
}