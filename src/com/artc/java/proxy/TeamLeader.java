package com.artc.java.proxy;

public class TeamLeader implements Manager {
    @Override
    public void manage() {
        System.out.println("This is a TeamLeader!");
    }
}
