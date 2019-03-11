package com.artc.java.proxy;

import java.lang.reflect.Proxy;

public class ProxyForImplementApp {

    public static void main(String[] args) {
        Manager leader = new TeamLeader();
        Manager manager = (Manager) Proxy.newProxyInstance(leader.getClass().getClassLoader(),
                                                           leader.getClass().getInterfaces(),
                                                           (proxy, method, objects) -> {
                                                               System.out.println("This method name is : " + method.getName());
                                                               return null;
                                                           });
        manager.manage();
    }

}
