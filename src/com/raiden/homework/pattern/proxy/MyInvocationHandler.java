package com.raiden.homework.pattern.proxy;

import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Author: Raiden
 * Date: 2019/3/15
 */
public interface MyInvocationHandler {

    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable;
}
