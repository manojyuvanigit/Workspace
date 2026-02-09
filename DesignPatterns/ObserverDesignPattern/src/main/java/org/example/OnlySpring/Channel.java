package org.example.OnlySpring;

import java.util.ArrayList;
import java.util.List;

public class Channel {

    public String name;

    public void setName(String name) {
        this.name = name;
    }

    public void subscribeChannel(Subscriber subscriber) {
        this.subscriberList.add(subscriber);
        subscriber.addChannelList(this.name);
    }

    public void unSubscribeChannel(Subscriber subscriber) {
        this.subscriberList.remove(subscriber);
        subscriber.removeChannelList(this.name);
    }

    public void uploadVideo(String videoSubject){
        System.out.println("New video uploaded in channel " + this.name + ": " + videoSubject);
        updateSubscribers(videoSubject);
    }

    public void updateSubscribers(String message) {
        for (Subscriber subscriber : subscriberList) {
            System.out.println("Notifying " + subscriber.name + " about new message in channel " + this.name + ": " + message);
        }
    }

    public List<Subscriber> subscriberList = new ArrayList<Subscriber>();


}
