package com.artc.java.proxy;

public class TeamLeader implements Manager {
    @Override
    public void manage() {
        System.out.println("This is a TeamLeader!");
    }

    @Override
    public String concat(String value1, String value2) {
        return String.format("%s%s", value1, value2);
    }
}
