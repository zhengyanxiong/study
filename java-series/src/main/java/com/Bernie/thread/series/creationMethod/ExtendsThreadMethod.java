package com.Bernie.thread.series.creationMethod;

/**
 * create by: Bernie
 * description: 通过继承 Thread->{@link java.lang.Thread}类实现
 * create time: 2020/10/21 22:54
 * 实现两个线程并发计算0-1000的和
 */
public class ExtendsThreadMethod extends Thread {
    private int start, end, sum = 0;

    ExtendsThreadMethod(String name, int start, int end) {
        super(name);
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        System.out.println("线程：" + getName() + " 开始执行！");
        for (int i = start; i <= end; i++) {
            sum += i;
        }
        System.out.println("线程：" + getName() + " 执行结束！sum=" + this.sum);
    }

    public static void main(String[] args) throws InterruptedException{
        int start = 0, mid = 500, end = 1000, sum = 0;

        ExtendsThreadMethod threadMethod1 = new ExtendsThreadMethod("thread1",start,mid);
        ExtendsThreadMethod threadMethod2 = new ExtendsThreadMethod("thread2",mid + 1, end);

        threadMethod1.start();
        threadMethod2.start();

        // 确保两个线程执行完
        threadMethod1.join();
        threadMethod2.join();

        sum = threadMethod1.sum + threadMethod2.sum;
        System.out.println("结果：" + sum);
    }
}
