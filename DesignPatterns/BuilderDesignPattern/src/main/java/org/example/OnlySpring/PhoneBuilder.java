package org.example.OnlySpring;

public class PhoneBuilder {

    public String model;
    public int price;

    public PhoneBuilder setModel(String model) {
        this.model = model;
        return this;
    }

    public PhoneBuilder setPrice(int price) {
        this.price = price;
        return this;
    }

    public PhoneBuilder setColor(String color) {
        this.color = color;
        return this;
    }

    public PhoneBuilder setScreenSize(String screenSize) {
        this.screenSize = screenSize;
        return this;
    }

    public String color;
    public String screenSize;

    public Phone getPhone(){
        return new Phone(model, price, color, screenSize);
    }

}
