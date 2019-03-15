package com.raiden.homework.pattern.proxy;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Author: Raiden
 * Date: 2019/3/15
 */
public class MyClassloader extends ClassLoader {

    public Class<?> defineClass0(String name, byte[] b, int off, int len) {
        try {
            return super.defineClass( name, b, off, len);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
