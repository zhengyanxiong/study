package com.Bernie.entity;

/**
 * create by: Bernie
 * description: TODO
 * create time: 2020/12/28 19:45
 */
public class Student {
    private static Student student;

    private Student() {
        //构造函数私有化
    }
    /**
     * @description: 单例模式之懒汉式
     * @return: com.Bernie.entity.Student
     * @author: Bernie
     * @date: 2020/12/28
     */
    public static Student getInstance() {
        if (student == null) {
            //return new Student();
            synchronized (Student.class){
                student = new Student();
            }
        }
        return student;
    }
}
