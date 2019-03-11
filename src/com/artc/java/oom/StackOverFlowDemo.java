package com.artc.java.oom;

public class StackOverFlowDemo {

    public static void main(String[] args) {
        int i = 0;
        while (i >= 0) {
            i++;
        }
    }

    public int getInt(int defaultValue) {
        if (defaultValue > 0)
            return defaultValue;
        return getInt(defaultValue + 1);
    }
}
