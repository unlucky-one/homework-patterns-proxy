package com.raiden.homework.pattern.proxy;

import sun.misc.ProxyGenerator;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Author: Raiden
 * Date: 2019/3/15
 */
public class MyProxy {
    static Map<MyClassloader, Map> loaderToCache = new HashMap<MyClassloader, Map>();
    static Object pendingGenerationMarker;

    public static Object newProxyInstance(MyClassloader loader,
                                          Class<?>[] interfaces,
                                          InvocationHandler h)
            throws IllegalArgumentException {
        if (h == null) {
            throw new NullPointerException();
        }
        Class cl = getProxyClass(loader, interfaces);

        try {
            Constructor cons = cl.getConstructor(InvocationHandler.class);
            return (Object) cons.newInstance(h);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Class<?> getProxyClass(MyClassloader loader, Class<?>... interfaces)
            throws IllegalArgumentException {
        if (interfaces.length > 65535) {
            throw new IllegalArgumentException("interface limit exceeded");
        }

        Class proxyClass = null;
        try {
            String proxyName = loader.getClass().getPackage().getName() + ".$Proxy0";
            byte[] proxyClassFile = ProxyGenerator.generateProxyClass(
                    proxyName, interfaces);
            proxyClass = loader.defineClass0(proxyName,
                    proxyClassFile, 0, proxyClassFile.length);
        } catch (ClassFormatError e) {
            throw new IllegalArgumentException(e.toString());
        }
        return proxyClass;
    }


}
