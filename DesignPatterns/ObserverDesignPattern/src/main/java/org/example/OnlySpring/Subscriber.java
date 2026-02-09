package org.example.OnlySpring;

import java.util.ArrayList;
import java.util.List;

public class Subscriber {
    public Subscriber(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addChannelList(String channel) {
        this.channelList.add(channel);
    }

    public void removeChannelList(String channel) {
        this.channelList.remove(channel);
    }

    public void showChannelList() {
        System.out.println("Channels subscribed by " + this.name + ": " + String.join(", ", this.channelList));
    }

    public String name;
    public List<String> channelList= new ArrayList<String>();
}
