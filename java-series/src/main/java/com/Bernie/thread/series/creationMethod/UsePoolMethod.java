package com.Bernie.thread.series.creationMethod;

import java.util.concurrent.*;

/**
 * create by: Bernie
 * description: 使用线程池创建
 * create time: 2020/10/21 23:37
 */
public class UsePoolMethod implements Callable<Integer> {
    private int start, end;

    UsePoolMethod(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public Integer call() throws Exception {
        System.out.println("线程池：" + Thread.currentThread().getName() + " 开始执行！");
        int sum = 0;
        for (int i=start;i<=end;i++) {
            sum += i;
        }
        System.out.println("线程池：" + Thread.currentThread().getName() + " 执行结束！sum=" + sum);
        return sum;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int start = 0, mid = 500, end = 1000, sum = 0;

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        FutureTask<Integer> futureTask1 = (FutureTask<Integer>) executorService.submit(new UsePoolMethod(start, mid));
        FutureTask<Integer> futureTask2 = (FutureTask<Integer>) executorService.submit(new UsePoolMethod(mid +1, end));

        sum = futureTask1.get() + futureTask2.get();
        System.out.println("结果：" + sum);
    }
}
