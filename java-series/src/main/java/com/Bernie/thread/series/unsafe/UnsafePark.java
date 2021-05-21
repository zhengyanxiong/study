package com.Bernie.thread.series.unsafe;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.TimeUnit;

/**
 * @author Bernie
 * @Date 2021/05/11 21:21
 * @see sun.misc.Unsafe 线程调度
 */
public class UnsafePark {
    private static Unsafe unsafe;

    static {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            unsafe = (Unsafe) field.get(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void method1() throws InterruptedException {
        Thread thread = new Thread(() -> {
            System.out.println(String.format("%s, %s, start.", System.currentTimeMillis(), Thread.currentThread().getName()));
            unsafe.park(false, 0);
            System.out.println(String.format("%s, %s, end.", System.currentTimeMillis(), Thread.currentThread().getName()));
        });
        thread.setName("线程1");
        thread.start();

        TimeUnit.SECONDS.sleep(5);
        unsafe.unpark(thread);
    }

    static void method2() throws InterruptedException {
        Thread thread = new Thread(() -> {
            System.out.println(String.format("%s, %s, start.", System.currentTimeMillis(), Thread.currentThread().getName()));
            unsafe.park(false, TimeUnit.SECONDS.toNanos(3));
            System.out.println(String.format("%s, %s, end.", System.currentTimeMillis(), Thread.currentThread().getName()));
        });
        thread.setName("线程2");
        thread.start();
    }

    public static void main(String[] args) throws InterruptedException{
        method1();
        method2();
    }
}
