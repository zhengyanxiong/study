package com.Bernie.reflection;

import java.lang.reflect.Field;

/**
 * create by: Bernie
 * description: Student类
 * create time: 2020/10/24 16:48
 */
public class Student {
    private String name;
    public int age;

    public Student(){}

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private String show(String message) {
        System.out.println("show: " + name + "," + age + "," + message);
        return "testReturnValue";
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) throws ClassNotFoundException {
        // 1: Use Class.forName([Class path])
        Class studentClass1 = Class.forName("com.Bernie.reflection.Student");
        // 2：Through the class attribute of the class
        Class studentClass2 = Student.class;
        // 3: Use Object.getClass()
        Class studentClass3 = new Student().getClass();

        System.out.println("class1 = " + studentClass1);
        System.out.println("class2 = " + studentClass2);
        System.out.println("class3 = " + studentClass3);

        System.out.println("studentClass1 == studentClass2 ? " + (studentClass1 == studentClass2));
        System.out.println("studentClass2 == studentClass3 ? " + (studentClass2 == studentClass3));
        System.out.println("studentClass1 == studentClass3 ? " + (studentClass1 == studentClass3));

        // 获取成员变量
        System.out.println("\n--------------------");
        System.out.println("use getDeclaredFields：");
        Field[] fields = studentClass1.getDeclaredFields();
        for (Field field : fields) {
            System.out.println("declaredFields: " + field);
        }
        System.out.println("use getFields：");
        fields = studentClass1.getFields();
        for (Field field : fields) {
            System.out.println("getFields: " + field);
        }
    }
}
