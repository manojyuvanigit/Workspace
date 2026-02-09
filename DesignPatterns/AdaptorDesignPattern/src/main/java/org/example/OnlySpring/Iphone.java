package org.example.OnlySpring;

public class Iphone {

    Charger charger;

    public void setCharger(Charger charger) {
        this.charger = charger;
    }

    public void charge(String owner)  {
        charger.charge(owner);
    }
}
