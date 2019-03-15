package com.raiden.homework.pattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Author: Raiden
 * Date: 2019/3/15
 */
public class DynamicProxy implements InvocationHandler {

    private Object target;

    public Object proxy(Class<?> targetClass) {
        try {
            this.target = targetClass.newInstance();
            return MyProxy.newProxyInstance(new MyClassloader(),
                    targetClass.getInterfaces(), this);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("搜集房源");
        Object invoke = method.invoke(target, args);
        System.out.println("交付");
        return invoke;
    }

    private void before() {
        System.out.println("搜集房源");
    }

    private void after() {
        System.out.println("交付");
    }
}
