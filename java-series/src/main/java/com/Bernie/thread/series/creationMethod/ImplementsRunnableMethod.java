package com.Bernie.thread.series.creationMethod;

/**
 * create by: Bernie
 * description: 通过实现 Runnable->{@link java.lang.Runnable}类实现
 * create time: 2020/10/21 23:13
 */
public class ImplementsRunnableMethod implements Runnable{
    private int start, end, sum = 0;

    ImplementsRunnableMethod( int start, int end) {
        this.start = start;
        this.end = end;
    }
    public void run() {
        System.out.println("线程：" + Thread.currentThread().getName() + " 开始执行！");
        for (int i = start; i <= end; i++) {
            sum += i;
        }
        System.out.println("线程：" + Thread.currentThread().getName() + " 执行结束！sum=" + this.sum);
    }

    public static void main(String[] args) throws InterruptedException {
        int start = 0, mid = 500, end = 1000, sum = 0;

        ImplementsRunnableMethod method1 = new ImplementsRunnableMethod(start, mid);
        ImplementsRunnableMethod method2 = new ImplementsRunnableMethod(mid + 1, end);

        Thread thread1 = new Thread(method1, "线程1");
        Thread thread2 = new Thread(method2, "线程2");

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        sum = method1.sum + method2.sum;
        System.out.println("结果：" + sum);
    }
}
