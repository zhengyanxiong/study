package com.Bernie.thread.series.synchroinizeds;

import javax.swing.text.DateFormatter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author Bernie
 * @Date 2020/10/21/021 16:06
 *
 */
public class Condition1 {
    private static int num = 0;
    private static ReentrantLock lock = new ReentrantLock();

    public static void m1() {
        lock.lock();
        try {
            for (int i=0; i<10000; i++) {
                num++;
            }
        } finally {
            lock.unlock();
        }

    }

    public static class T1 extends Thread {
        @Override
        public void run() {
            Condition1.m1();
        }
    }

    public static void main(String[] args) throws InterruptedException{
        T1 t1 = new T1();
        T1 t2 = new T1();
        T1 t3 = new T1();
        T1 t4 = new T1();

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        t1.join();
        t2.join();
        t3.join();
        t4.join();

        System.out.println(Condition1.num);
    }
}
