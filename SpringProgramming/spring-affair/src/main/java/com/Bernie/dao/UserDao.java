package com.Bernie.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author Bernie
 * @Date 2019/1/18 15:02
 **/
@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void add(String name, Integer age) {
        String sql = "INSERT INTO users(NAME, age) VALUES(?,?);";
        int update = jdbcTemplate.update(sql, name, age);
        System.out.println("添加数据user成功:" + update);
    }

}
