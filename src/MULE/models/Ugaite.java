package MULE.models;

//Created by Antonia on 11/4/2015.

public class Ugaite implements Race {
    private final int startMoney;
    public Ugaite() {startMoney = 1000;}

    @Override
    public int startMoney() {
        return startMoney;
    }
}
