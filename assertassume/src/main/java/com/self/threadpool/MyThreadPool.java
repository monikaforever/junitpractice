package com.self.threadpool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.*;

/**
 * @author 张琪
 * @date 2022/11/28 17:16
 */
public class MyThreadPool {
    private static final Logger log = LoggerFactory.getLogger(MyThreadPool.class);

    /**
     * 核心线程数: 核心线程一旦创建, 不会消失
     */
    public final static int CORE_POOL_SIZE = 8;

    /**
     * 线程池最大线程数: 超过该上限的线程会被阻塞
     */
    public final static int MAXIMUM_POOL_SIZE = 16;

    /**
     * 线程闲置超时时长: 超过该时长, 非核心线程会被回收
     */
    public final static int KEEP_ALIVE_TIME = 60;

    /**
     * 核心线程能否超时: 为true时, 超时被回收
     */
    public final static boolean ALLOW_CORE_THREAD_TIMEOUT = false;

    /**
     * 线程超时时长(allowCoreThreadTimeout)的单位:  所有单位都从TimeUnit中获取
     */
    public final static TimeUnit UNIT = TimeUnit.SECONDS;

    /**
     * 排队队列, 用于存放所有需要执行的事物
     */
    public final static BlockingQueue<Runnable> QUEUE = new ArrayBlockingQueue<>(20);

    /**
     * 配置线程池
     */
    public final static ThreadPoolExecutor threadPool = new ThreadPoolExecutor(CORE_POOL_SIZE,
            MAXIMUM_POOL_SIZE, KEEP_ALIVE_TIME, UNIT, QUEUE);

}
