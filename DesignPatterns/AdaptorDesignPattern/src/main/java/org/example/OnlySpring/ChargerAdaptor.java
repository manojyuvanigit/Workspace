package org.example.OnlySpring;

public class ChargerAdaptor implements Charger{

    PilotCharger pilotCharger = new PilotCharger();
    @Override
    public void charge(String owner) {
        pilotCharger.slowCharge(owner);
    }
}
