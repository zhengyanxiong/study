package com.Bernie.design.factory.abstracts.factory;

/**
 * create by: Bernie
 * description: TODO
 * create time: 2020/11/19 23:35
 */
public interface ICacheAdapter {
    String get(String key);
    void set(String key,String value);
    void del(String key);
}
