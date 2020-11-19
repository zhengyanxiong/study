package com.Bernie.design.factory.abstracts.impl;

import com.Bernie.design.factory.abstracts.ICacheService;
import com.Bernie.design.factory.abstracts.redis.RedisUtils;

/**
 * create by: Bernie
 * description: TODO
 * create time: 2020/11/19 23:25
 */
public class CacheServiceImpl implements ICacheService {
    private RedisUtils redisUtils = new RedisUtils();
    @Override
    public String get(String key) {
        return redisUtils.get(key);
    }

    @Override
    public void set(String key, String value) {
        redisUtils.set(key, value);
    }

    @Override
    public void del(String key) {
        redisUtils.delete(key);
    }
}
