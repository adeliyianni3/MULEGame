package MULE.models;

//Created by Antonia on 11/4/2015.

public class Flapper implements Race {
    private int startMoney = 1600;

    public Flapper() {}

    @Override
    public int startMoney() {
        return startMoney;
    }
}
