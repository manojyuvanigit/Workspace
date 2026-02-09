package org.example;

public class YoungMan implements Man{
    @Override
    public void speak(String message) {
        System.out.println("I am below 30 age");
    }
}
