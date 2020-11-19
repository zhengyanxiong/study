package com.Bernie.design.factory.abstracts.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * create by: Bernie
 * description: TODO
 * create time: 2020/11/19 23:22
 */
public class RedisUtils {
    private Logger logger = LoggerFactory.getLogger(RedisUtils.class);

    private Map<String,String> dataMap = new ConcurrentHashMap<>();

    public String get(String key) {
        logger.info("Redis获取数据 key:"+key);
        return dataMap.get(key);
    }

    public void set(String key,String value) {
        logger.info("Redis插入数据 key:" + key + ";value:" + value);
        dataMap.put(key,value);
    }

    public void delete(String key) {
        logger.info("Redis删除数据 key:" + key);
        dataMap.remove(key);
    }
}
