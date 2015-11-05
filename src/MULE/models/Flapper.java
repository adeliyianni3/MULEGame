package MULE.models;

//Created by Antonia on 11/4/2015.

public class Flapper implements Race {
    private int startMoney;

    public Flapper() {startMoney = 1600;}

    @Override
    public int startMoney() {
        return startMoney;
    }
}
