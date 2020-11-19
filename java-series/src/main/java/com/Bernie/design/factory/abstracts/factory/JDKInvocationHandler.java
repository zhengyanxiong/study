package com.Bernie.design.factory.abstracts.factory;

import com.Bernie.design.factory.abstracts.utils.ClassLoaderUtils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * create by: Bernie
 * description: TODO
 * create time: 2020/11/19 23:42
 */
public class JDKInvocationHandler implements InvocationHandler {

    private ICacheAdapter iCacheAdapter;

    public JDKInvocationHandler(ICacheAdapter iCacheAdapter) {
        this.iCacheAdapter = iCacheAdapter;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return iCacheAdapter.getClass().getMethod(method.getName(), ClassLoaderUtils.getClazzByArgs(args)).invoke(iCacheAdapter,args);
    }
}
