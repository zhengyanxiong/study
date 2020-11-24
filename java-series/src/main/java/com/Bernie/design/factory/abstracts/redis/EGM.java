package com.Bernie.design.factory.abstracts.redis;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author Bernie
 * @Date 2020/11/18/018 17:06
 */
public class EGM {
   private Logger logger = LoggerFactory.getLogger(EGM.class);

   private Map<String,String> dataMap = new ConcurrentHashMap<>();

   public String getE(String key) {
       logger.info("BGM获取数据 key:"+key);
       return dataMap.get(key);
   }

   public void setE(String key,String value) {
       logger.info("BGM插入数据 key:" + key + ";value:" + value);
       dataMap.put(key,value);
   }

   public void delete(String key) {
       logger.info("BGM删除数据 key:" + key);
       dataMap.remove(key);
   }
}
