package com.Bernie.thread.series.countDownLatch;

import org.apache.commons.collections.CollectionUtils;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Bernie
 * @Date 2021/05/07 14:41
 * 一个任务并行处理工具类
 */
public class TaskDisposeUtils {
    // 并行线程数
    public static final int POOL_SIZE;

    static {
        // 初始化选择系统默认处理器数量和默认值取最大值
        POOL_SIZE = Integer.max(Runtime.getRuntime().availableProcessors(), 5);
    }

    /**
     * 并行处理任务，等待结束
     *
     * @param taskList 任务列表
     * @param consumer 消费者
     * @param <T>
     * @throws InterruptedException
     */
    public static <T> void dispose(List<T> taskList, Consumer<T> consumer) throws InterruptedException {
        dispose(true, POOL_SIZE, taskList, consumer);
    }

    /**
     * 并行处理任务，并等待结束
     *
     * @param moreThread 是否是多线程
     * @param poolSize   线程池大小
     * @param taskList   任务列表
     * @param consumer   消费者
     * @param <T>
     * @throws InterruptedException
     */
    private static <T> void dispose(boolean moreThread, int poolSize, List<T> taskList, Consumer<T> consumer) throws InterruptedException {
        if (CollectionUtils.isEmpty(taskList)) {
            return;
        }

        if (moreThread && taskList.size() > 1) {
            // 多线程并行处理
            // 线程池大小，选择任务个数和默认最小的一个
            poolSize = Math.min(poolSize, taskList.size());
            ExecutorService executorService = null;
            try {
                executorService = Executors.newFixedThreadPool(poolSize);
                // 创建CountDownLatch 对象
                CountDownLatch countDownLatch = new CountDownLatch(taskList.size());
                for (T task : taskList) {
                    executorService.execute(() -> {
                        try {
                            consumer.accept(task);
                        } finally {
                            countDownLatch.countDown();
                        }
                    });
                }
                // 在任务完成前，阻塞等待
                countDownLatch.await();
            } finally {
                if (executorService != null) {
                    executorService.shutdown();
                }
            }
        } else {
            // 单个线程直接处理
            for (T task : taskList) {
                consumer.accept(task);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException{
        //生成1-10的10个数字，放在list中，相当于10个任务
        List<Integer> task = Stream.iterate(1, a -> a + 1).limit(10).collect(Collectors.toList());
        // 启动多线程处理
        TaskDisposeUtils.dispose(task, item -> {
            try {
                long startTime = System.currentTimeMillis();
                TimeUnit.SECONDS.sleep(item);
                long endTime = System.currentTimeMillis();
                System.out.println(System.currentTimeMillis() + ",任务" + item + "执行完毕！总共耗时："+ (endTime - startTime));
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        });
        System.out.println(task + "中任务全部处理完成！");
    }
}
