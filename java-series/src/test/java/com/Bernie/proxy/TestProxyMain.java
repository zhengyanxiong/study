package com.Bernie.proxy;

import com.Bernie.proxy.impl.StudentServiceImpl;
import com.Bernie.proxy.impl.StudentServiceStaticProxy;
import org.junit.Test;

import java.lang.reflect.*;

/**
 * @Author Bernie
 * @Date 2020/11/13/013 14:11
 */
public class TestProxyMain {

    private Object getProxy(final Object target) {
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler() {
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("---------------------------");
                        System.out.println("使用静态代理");
                        System.out.println("---------------------------");
                        System.out.println(method.getName() + "方法执行前......");
                        System.out.println(method.getName() + "方法开始执行......");
                        Object result = method.invoke(target,args);
                        System.out.println(method.getName() + "方法开始执后......");
                        System.out.println("---------------------------");
                        System.out.println("使用静态代理,结束");
                        System.out.println("---------------------------");
                        return result;
                    }
                });
    }

    @Test
    public void staticProxy() {
        StudentService studentService = new StudentServiceImpl();
        StudentServiceStaticProxy studentServiceStaticProxy = new StudentServiceStaticProxy(studentService);
        studentServiceStaticProxy.getStudent();
    }

    @Test
    public void dynamicProxy() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //1、定义目标对象
        StudentService studentService = new StudentServiceImpl();
        //2、获取代理Class对象
        Class studentProxy = Proxy.getProxyClass(studentService.getClass().getClassLoader(),studentService.getClass().getInterfaces());
        //3、得到有参构造器
        Constructor constructor = studentProxy.getConstructor(InvocationHandler.class);
        //4、反射获取代理实例对象
        StudentService studentService1 = (StudentService) constructor.newInstance(new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("-----------------------");
                System.out.println("动态代理");
                System.out.println("-----------------------");
                // 手动创建目标对象
                StudentServiceImpl service = new StudentServiceImpl();
                // 反射执行目标对象的方法
                Object object = method.invoke(service,args);
                // 返回执行结果
                return object;
            }
        });

        System.out.println(studentService1.getStudent().toString());
    }

    @Test
    public void dynamicProxy2() {
        StudentServiceImpl studentService = new StudentServiceImpl();
        StudentService studentService1 = (StudentService) getProxy(studentService);
        System.out.println(studentService1.getStudent());
        int f = 3-8;
        System.out.println(f);
        System.out.println(3-8);
    }
}
