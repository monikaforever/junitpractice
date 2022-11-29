package com.self.threadpool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author 张琪
 * @date 2022/11/24 18:30
 */
public class BaseThreadPool {
    private static final Logger log = LoggerFactory.getLogger(BaseThreadPool.class);

    public static void main(String[] args) {
        // ExecutorService executor = getSingleThreadPool();
        // 创建线程池长度为 5 的线程池
        // ExecutorService executor = getFixedTheadPool(5);
        // 创建带缓存的线程池
        // ExecutorService executor = getCacheThreadPool();
        // for (int i = 0; i < 10; i++) {
        //     executor.submit(BaseThreadPool::commonTasks);
        // }

        getScheduledThreadPool();
    }

    public static ExecutorService getFixedTheadPool(int nThreads) {
        return Executors.newFixedThreadPool(nThreads);
    }

    public static ExecutorService getSingleThreadPool() {
        return Executors.newSingleThreadExecutor();
    }

    public static ExecutorService getCacheThreadPool() {
        return Executors.newCachedThreadPool();
    }

    /**
     * 创建定时调度线程池
     * @return
     */
    public static void getScheduledThreadPool() {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);
        // 每个调度任务会至少等待 period 时间
        // 任务执行时长 > period, 则等待的时间为任务执行的时间

        // quartz -- 阻塞模式, 本次任务执行完成后才会执行下次任务
        // 实际间隔 = 执行时间 > period ? 执行时间 : period
        scheduledExecutorService.scheduleAtFixedRate(() -> {
            try {
                System.out.println(System.currentTimeMillis() / 1000);
                System.out.println("休眠10s");
                Thread.sleep(10000);
                System.out.println(System.currentTimeMillis() / 1000);
                System.out.println("--------------------------");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, 0, 2, TimeUnit.SECONDS);

        // quartz -- 普通模式, 实际间隔 = delay + 执行时间
        scheduledExecutorService.scheduleWithFixedDelay(() -> {
            try {
                System.out.println(System.currentTimeMillis() / 1000);
                System.out.println("休眠5s");
                Thread.sleep(5000);
                System.out.println(System.currentTimeMillis() / 1000);
                System.out.println("--------------------------");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, 0, 2, TimeUnit.SECONDS);

        // 单次执行
        scheduledExecutorService.schedule(() -> {
            System.out.println("5 秒后执行 schedule");
            System.out.println("---------------------------");
        }, 5, TimeUnit.SECONDS);
    }

    public static void commonTasks() {
        System.out.println("threadId is : " + Thread.currentThread().getId());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
