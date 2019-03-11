package com.artc.java.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyInterfaceApp {

    /*
    动态代理文章: http://www.importnew.com/23168.html
    JVM 参数 : -Dsun.misc.ProxyGenerator.saveGeneratedFiles=true (保存字节码到磁盘)
     */
    public static void main(String[] args) {
        Manager printNameProxy = getProxy(MyProxy.of(Manager.class));
        printNameProxy.manage();
    }

    private static <T> T getProxy(MyProxy<T> proxy) {
        return (T) Proxy.newProxyInstance(proxy.getClass().getClassLoader(), proxy.interfaces, proxy);
    }

    static class MyProxy<T> implements InvocationHandler {
        private Class<T>[] interfaces;

        private MyProxy(Class<T> cls) {
            this.interfaces = new Class[]{cls};
        }

        public static <T> MyProxy<T> of(Class<T> cls) {
            return new MyProxy(cls);
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("MyProxy.invoke");
            System.out.println(proxy.getClass().getName());
            // method.invoke(proxy, args); // Infinite loop
            return null;
        }
    }

}
