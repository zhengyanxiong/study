package com.Bernie.thread.series.cas;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author Bernie
 * @Date 2021/05/11 17:08
 * 使用 volatile 加锁
 */
public class WebsiteCounter3 {
    private static volatile int count = 0;

    public static  void request() throws InterruptedException {
        TimeUnit.MICROSECONDS.sleep(5);
        int expectCount;
        do {
            expectCount = getCount();
        } while (!compareAndSwap(expectCount, expectCount + 1));
    }

    public static int getCount() {
        return count;
    }

    /**
     *
     * @param expectCount 期望值
     * @param newCount 新值
     */
    public static synchronized boolean compareAndSwap(int expectCount, int newCount) throws InterruptedException {
        if (getCount() == expectCount) {
            count = newCount;
            return true;
        }
        return false;
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
    // [main], 耗时：[66]，访问量：count=[1000]
}
