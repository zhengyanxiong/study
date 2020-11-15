package com.Bernie.proxy.impl;

import com.Bernie.proxy.StudentService;
import com.Bernie.reflection.Student;

/**
 * @Author Bernie
 * @Date 2020/11/13/013 14:07
 */
public class StudentServiceImpl implements StudentService {
    public Student getStudent() {
        return new Student("Bernie",25);
    }
}
