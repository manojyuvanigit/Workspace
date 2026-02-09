package org.example.OnlySpring;

public class Main {
    public static void main(String[] args) {
        Composite computer = new Composite("Computer");
        Composite motherboard = new Composite("Motherboard");
        Composite HD = new Composite("Hard Drive");

        Component cpu = new Leaf("CPU", "250");
        Component ram = new Leaf("RAM", "150");
        Component ssd = new Leaf("SSD", "200");

        Component hdd1 = new Leaf("HDD 1TB", "100");

        motherboard.addComponent(cpu);
        motherboard.addComponent(ram);
        motherboard.addComponent(ssd);
        computer.addComponent(motherboard);

        HD.addComponent(hdd1);
        computer.addComponent(HD);

        computer.showPrice();

    }
}