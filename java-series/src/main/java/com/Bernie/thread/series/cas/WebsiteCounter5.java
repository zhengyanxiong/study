package com.Bernie.thread.series.cas;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Bernie
 * @Date 2021/05/11 17:08
 * 使用 JUC中的类实现计数器
 */
public class WebsiteCounter5 {
    private static Unsafe unsafe;
    private static int count;
    private static long countOffset;

    static {
        try {
            Field unsafeFiled = Unsafe.class.getDeclaredField("theUnsafe");
            unsafeFiled.setAccessible(true);
            unsafe = (Unsafe) unsafeFiled.get(null);
            Field field = WebsiteCounter5.class.getDeclaredField("count");
            countOffset = unsafe.staticFieldOffset(field);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void request() throws InterruptedException {
        TimeUnit.MICROSECONDS.sleep(5);
        unsafe.getAndAddInt(WebsiteCounter5.class, countOffset, 1);
    }


    public static void main(String[] args) throws InterruptedException{
        long startTime = System.currentTimeMillis();
        int threadSize = 100;
        CountDownLatch countDownLatch = new CountDownLatch(threadSize);
        for (int i=0; i< threadSize; i++) {
            new Thread(() -> {
                try {
                    for (int j=0; j< 10; j++) {
                        request();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    countDownLatch.countDown();
                }

            }).start();
        }

        countDownLatch.await();
        long endTime = System.currentTimeMillis();
        System.out.println(String.format("[%s], 耗时：[%s]，访问量：count=[%s]", Thread.currentThread().getName(), endTime - startTime, count));
    }

    // 输出结果：
    // [main], 耗时：[65]，访问量：count=[1000]
}
