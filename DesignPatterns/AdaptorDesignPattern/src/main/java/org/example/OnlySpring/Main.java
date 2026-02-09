package org.example.OnlySpring;
import org.example.OnlySpring.Iphone;

public class Main {
    public static void main(String[] args) {
        Charger charger = new ChargerAdaptor();
        Iphone iphone = new Iphone();
        iphone.setCharger(charger);
        iphone.charge("Manoj IPhone");
    }
}