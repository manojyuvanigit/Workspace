package org.example.OnlySpring;

public class Leaf implements Component{

    String name = "", price = "";

    public Leaf(String name, String price){
        this.name = name;
        this.price = price;
    }
    @Override
    public void showPrice() {
        System.out.println(name + " : " + price);
    }
}
