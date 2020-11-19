package com.Bernie.design.factory.abstracts;

import com.Bernie.design.factory.abstracts.factory.ICacheAdapter;
import com.Bernie.design.factory.abstracts.factory.JDKProxy;
import com.Bernie.design.factory.abstracts.factory.impl.EGMCacheAdapterImpl;
import com.Bernie.design.factory.abstracts.factory.impl.IIPCacheAdapterImpl;
import com.Bernie.design.factory.abstracts.impl.CacheServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * create by: Bernie
 * description: TODO
 * create time: 2020/11/20 0:04
 */
public class ICacheServiceTest {
    @Test
    public void test() {
        ICacheService iCacheService = new CacheServiceImpl();
        iCacheService.set("g","gg");
        System.out.println(iCacheService.get("g"));

        ICacheService cacheService = JDKProxy.getProxy(CacheServiceImpl.class,new EGMCacheAdapterImpl());
        cacheService.set("name","Bernie");
        System.out.println(cacheService.get("name"));

        ICacheService cacheService1 = JDKProxy.getProxy(CacheServiceImpl.class,new IIPCacheAdapterImpl());
        cacheService1.set("j","夹间");
        System.out.println(cacheService1.get("j"));
    }
}