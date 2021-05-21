package com.Bernie.thread.series.cas;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Bernie
 * @Date 2021/05/11 17:08
 * 使用 JUC中的类实现计数器
 */
public class WebsiteCounter4 {
    private static volatile AtomicInteger count = new AtomicInteger();

    public static void request() throws InterruptedException {
        TimeUnit.MICROSECONDS.sleep(5);
        count.incrementAndGet();
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
    // [main], 耗时：[60]，访问量：count=[1000]
}
