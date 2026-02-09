package org.example.OnlySpring;


public class Main {
    public static void main(String[] args) {
        Subscriber manoj =new Subscriber("Manoj");
        Subscriber yuvaraj =new Subscriber("Yuvaraj");
        Subscriber vani =new Subscriber("Vani");

        Channel myChannel = new Channel();
        myChannel.setName("Spring Boot Channel");
        myChannel.subscribeChannel(manoj);

        Channel newsChannel = new Channel();
        newsChannel.setName("Dailyhunt News");
        newsChannel.subscribeChannel(yuvaraj);
        newsChannel.subscribeChannel(manoj);

        Channel drawChannel = new Channel();
        drawChannel.setName("Kollam Channel");
        drawChannel.subscribeChannel(vani);

        manoj.showChannelList();

        myChannel.uploadVideo("Spring Boot Tutorial for Beginners");
        newsChannel.uploadVideo("Breaking News: Major Event Unfolds");

    }
}