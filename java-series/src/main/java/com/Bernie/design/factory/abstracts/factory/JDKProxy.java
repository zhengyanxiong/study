package com.Bernie.design.factory.abstracts.factory;

import java.lang.reflect.Proxy;

/**
 * create by: Bernie
 * description: TODO
 * create time: 2020/11/19 23:40
 */
public class JDKProxy {
    public static <T> T getProxy(Class<T> interfaceClass, ICacheAdapter iCacheAdapter){
        // 获取目标对象的ClassLoader
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        return (T) Proxy.newProxyInstance(classLoader,interfaceClass.getInterfaces(),new JDKInvocationHandler(iCacheAdapter));
    }
}
