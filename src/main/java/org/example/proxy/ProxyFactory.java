package org.example.proxy;

import org.example.handlers.GenericInvocationHandler;

import java.lang.reflect.Proxy;

public class ProxyFactory {
    public static <T> T createProxy(Class<T> interfaceType, T target) {
        return (T) Proxy.newProxyInstance(
                interfaceType.getClassLoader(),
                new Class<?>[]{interfaceType},
                new GenericInvocationHandler(target)
        );
    }
}
