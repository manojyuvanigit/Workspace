package org.example;

public class FactoryGenerator {

    public Man getInstance(String objType){
        if(objType.equalsIgnoreCase("YoungMan")){
            return new YoungMan();
        } else if(objType.equalsIgnoreCase("Father")){
            return new Father();
        } else if(objType.equalsIgnoreCase("OldMan")){
            return new OldMan();
        }
        return new Man() {
            @Override
            public void speak(String message) {
                System.out.println("No such type");
            }
        };
    }
}
