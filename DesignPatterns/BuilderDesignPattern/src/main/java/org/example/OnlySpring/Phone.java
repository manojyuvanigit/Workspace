package org.example.OnlySpring;

public class Phone {
    public String model;
    public int price;
    public String color;
    public String screenSize;

    public Phone (String model, int price, String color, String screenSize) {
        this.model = model;
        this.price = price;
        this.color = color;
        this.screenSize = screenSize;
    }

    public String toString() {
        return "Phone Model: " + model + ", Price: $" + price + ", Color: " + color + ", Screen Size: " + screenSize;
    }
}
