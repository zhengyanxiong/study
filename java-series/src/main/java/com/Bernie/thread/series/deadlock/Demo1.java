package com.Bernie.thread.series.deadlock;

/**
 * @author Bernie
 * @Date 2021/04/26 16:12
 * 死锁示例
 */
public class Demo1 {
    public static class Obj1 {}
    public static class Obj2 {}

    public static class SysAddRunnable implements Runnable {
        private Obj1 obj1;
        private Obj2 obj2;
        int a, b;
        boolean cancelled;

        SysAddRunnable(Obj1 obj1, Obj2 obj2, int a, int b, boolean cancelled) {
            this.obj1 = obj1;
            this.obj2 = obj2;
            this.a = a;
            this.b = b;
            this.cancelled = cancelled;
        }

        @Override
        public void run() {
            try {
                if (cancelled) {
                    synchronized (obj1) {
                        Thread.sleep(200);
                        synchronized (obj2) {
                            System.out.println(Thread.currentThread().getName() + ":" + a+b);
                        }
                    }
                } else {
                    synchronized (obj2) {
                        Thread.sleep(300);
                        synchronized (obj1) {
                            System.out.println(Thread.currentThread().getName() + ":" + a+b);
                        }
                    }
                }
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }

        }
    }

    public static void main(String[] args) {
        Obj1 obj1 = new Obj1();
        Obj2 obj2 = new Obj2();
        Thread thread1 = new Thread(new SysAddRunnable(obj1,obj2,10,20,true));
        thread1.setName("thread1");
        thread1.start();

        Thread thread2 = new Thread(new SysAddRunnable(obj1,obj2,10,40,false));
        thread2.setName("thread2");
        thread2.start();
    }
}
