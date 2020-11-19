package com.Bernie.design.factory.abstracts.factory.impl;

import com.Bernie.design.factory.abstracts.factory.ICacheAdapter;
import com.Bernie.design.factory.abstracts.redis.EGM;

/**
 * create by: Bernie
 * description: TODO
 * create time: 2020/11/19 23:36
 */
public class EGMCacheAdapterImpl implements ICacheAdapter {
    private EGM egm = new EGM();
    @Override
    public String get(String key) {
        return egm.getE(key);
    }

    @Override
    public void set(String key, String value) {
        egm.setE(key,value);
    }

    @Override
    public void del(String key) {
        egm.delete(key);
    }
}
