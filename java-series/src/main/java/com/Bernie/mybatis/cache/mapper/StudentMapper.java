package com.Bernie.mybatis.cache.mapper;

import com.Bernie.mybatis.cache.entry.StudentEntity;

/**
 * create by: Bernie
 * description: StudentMapper
 * create time: 2020/10/20 23:02
 */
public interface StudentMapper {
    public StudentEntity getStudentById(int id);
}
