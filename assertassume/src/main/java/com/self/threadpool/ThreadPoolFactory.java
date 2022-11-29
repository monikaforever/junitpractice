package com.self.threadpool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.*;

/**
 * @author 张琪
 * @date 2022/11/28 17:30
 */
public class ThreadPoolFactory {
    private static final Logger log = LoggerFactory.getLogger(ThreadPoolFactory.class);


    /**
     * 核心线程数: 核心线程一旦创建, 不会消失
     */
    private final static int CORE_POOL_SIZE = 8;

    /**
     * 线程池最大线程数: 超过该上限的线程会被阻塞
     */
    private final static int MAXIMUM_POOL_SIZE = 16;

    /**
     * 线程闲置超时时长: 超过该时长, 非核心线程会被回收
     */
    private final static int KEEP_ALIVE_TIME = 20;

    /**
     * 核心线程能否超时: 为true时, 超时被回收
     */
    private final static boolean ALLOW_CORE_THREAD_TIMEOUT = false;

    /**
     * 线程超时时长(allowCoreThreadTimeout)的单位:  所有单位都从TimeUnit中获取
     */
    private final static TimeUnit UNIT = TimeUnit.SECONDS;

    /**
     * 排队队列, 用于存放所有需要执行的事物
     */
    private final static BlockingQueue<Runnable> QUEUE = new ArrayBlockingQueue<>(20);

    /**
     * 获取基础版 线程池
     * @return 线程池对象
     */
    public static ExecutorService getCommonThreadPool() {
        return new ThreadPoolExecutor(CORE_POOL_SIZE,
                MAXIMUM_POOL_SIZE, KEEP_ALIVE_TIME, UNIT, QUEUE);
    }

}
