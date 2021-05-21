package com.Bernie.thread.series.cas;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author Bernie
 * @Date 2021/05/11 17:08
 * 使用 synchronized 加锁
 */
public class WebsiteCounter2 {
    private static int count = 0;

    public static synchronized  void request() throws InterruptedException {
        TimeUnit.MICROSECONDS.sleep(5);
        count++;
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
    // [main], 耗时：[1491]，访问量：count=[1000]
}
