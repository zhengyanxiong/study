package com.Bernie.thread.series.creationMethod;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * create by: Bernie
 * description: 通过实现 Callable -> {@link java.util.concurrent.Callable} 类
 *  结合FutureTask -> {@link java.util.concurrent.FutureTask} 返回一个值
 * create time: 2020/10/21 23:24
 */
public class ImplementsCallableMethod implements Callable<Integer> {
    private int start, end;

    ImplementsCallableMethod(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public Integer call() throws Exception {
        System.out.println("线程：" + Thread.currentThread().getName() + " 开始执行！");
        int sum = 0;
        for (int i=start;i<=end;i++) {
            sum += i;
        }
        System.out.println("线程：" + Thread.currentThread().getName() + " 执行结束！sum=" + sum);
        return sum;
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        int start = 0, mid = 500, end = 1000, sum = 0;

        FutureTask<Integer> futureTask1 = new FutureTask<Integer>(new ImplementsCallableMethod(start, mid));
        FutureTask<Integer> futureTask2 = new FutureTask<Integer>(new ImplementsCallableMethod(mid + 1, end));

        Thread thread1 = new Thread(futureTask1,"线程1");
        Thread thread2 = new Thread(futureTask2,"线程2");

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        sum = futureTask1.get() + futureTask2.get();
        System.out.println("结果：" + sum);
    }
}
