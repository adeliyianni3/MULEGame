package MULE.models;

//Created by Antonia on 11/4/2015.

public class Humanoid implements Race {
    private int startMoney;
    public Humanoid() {
        startMoney = 600;
    }

    @Override
    public int startMoney() {
        return startMoney;
    }
}
