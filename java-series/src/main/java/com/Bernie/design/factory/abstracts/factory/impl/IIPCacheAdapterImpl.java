package com.Bernie.design.factory.abstracts.factory.impl;

import com.Bernie.design.factory.abstracts.factory.ICacheAdapter;
import com.Bernie.design.factory.abstracts.redis.IIP;

/**
 * create by: Bernie
 * description: TODO
 * create time: 2020/11/19 23:38
 */
public class IIPCacheAdapterImpl implements ICacheAdapter {
    private IIP iip = new IIP();
    @Override
    public String get(String key) {
        return iip.getP(key);
    }

    @Override
    public void set(String key, String value) {
        iip.setP(key, value);
    }

    @Override
    public void del(String key) {
        iip.delete(key);
    }
}
