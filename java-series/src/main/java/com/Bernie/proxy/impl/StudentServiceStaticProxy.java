package com.Bernie.proxy.impl;

import com.Bernie.proxy.StudentService;
import com.Bernie.reflection.Student;

/**
 * @Author Bernie
 * @Date 2020/11/13/013 14:12
 */
public class StudentServiceStaticProxy implements StudentService {
    private StudentService studentService;

    public StudentServiceStaticProxy(StudentService studentService) {
        this.studentService = studentService;
    }

    public Student getStudent() {
        System.out.println("---------------------------");
        System.out.println("使用静态代理");
        System.out.println("---------------------------");
        System.out.println("判断是否有权限获取学生信息！");
        System.out.println("新的处理逻辑");
        Student student = studentService.getStudent();
        System.out.println(student.toString());
        System.out.println("记录获取的学生信息相关操作！");
        System.out.println("---------------------------");
        System.out.println("使用静态代理,结束");
        System.out.println("---------------------------");
        return student;
    }
}
