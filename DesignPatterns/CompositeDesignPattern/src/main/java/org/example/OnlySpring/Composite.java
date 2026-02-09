package org.example.OnlySpring;

import java.util.ArrayList;
import java.util.List;

public class Composite implements Component{

    String name = "";
    int price = 0;
    List<Component> componentList = new ArrayList<>();

    public Composite(String name){
        this.name = name;
    }

    public void addComponent(Component component){
        componentList.add(component);
    }
    @Override
    public void showPrice() {
        System.out.println(name);
        for(Component component : componentList){
            component.showPrice();
            if(component instanceof Leaf){
                this.price += ((Leaf)component).price != null ? Integer.parseInt(((Leaf)component).price) : 0;
            }else if(component instanceof Composite){
                this.price += Math.max(((Composite) component).price, 0);
            }
        }
        System.out.println("Total Price" + price);
    }
}
