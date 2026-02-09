package org.example.OnlySpring;


public class Main {
    public static void main(String[] args) {
        //Phone phone = new Phone("Galaxy S21", 799, "Phantom Gray", "6.2 inches");
        ///System.out.println(phone.toString());

        Phone phone = new PhoneBuilder().setColor("Black")
                .setPrice(999)
                .setScreenSize("6.1 inches")
                .getPhone();
        System.out.println(phone.toString());
    }
}