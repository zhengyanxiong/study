package com.Bernie.design.factory.abstracts;

/**
 * @Author Bernie
 * @Date 2020/11/18/018 17:16
 */
public interface ICacheService {
    String get(String key);
    void set(String key,String value);
    void del(String key);
}
