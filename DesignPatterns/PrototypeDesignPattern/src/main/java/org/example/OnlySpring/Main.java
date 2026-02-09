package org.example.OnlySpring;

public class Main {
    public static void main(String[] args) {
        BookShop bs = new BookShop();
        bs.setName("Manoj Book Shop" +bs);
        bs.loadData();
        bs.printBook();

        BookShop bs1 = bs.clone();
        bs1.setName("Yuvani Book Shop" + bs1);
        bs1.printBook();
    }
}