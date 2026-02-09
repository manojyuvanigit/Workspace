package org.example;

public class Main {
    public static void main(String[] args) {
        Man man = new FactoryGenerator().getInstance("OldMan");
        man.speak("hello");
    }
}