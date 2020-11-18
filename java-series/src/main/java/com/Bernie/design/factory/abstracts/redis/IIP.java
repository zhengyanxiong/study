package com.Bernie.design.factory.abstracts.redis;

import org.apache.log4j.Logger;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author Bernie
 * @Date 2020/11/18/018 17:15
 */
public class IIP {
    private Logger logger = Logger.getLogger(IIP.class);

    private Map<String,String> dataMap = new ConcurrentHashMap<>();

    public String getP(String key) {
        logger.info("IIP获取数据 key:"+key);
        return dataMap.get(key);
    }

    public void setP(String key,String value) {
        logger.info("IIP插入数据 key:" + key + ";value:" + value);
        dataMap.put(key,value);
    }

    public void delete(String key) {
        logger.info("IIP删除数据 key:" + key);
        dataMap.remove(key);
    }
}
