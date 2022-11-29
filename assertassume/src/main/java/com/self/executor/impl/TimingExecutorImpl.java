package com.self.executor.impl;

import com.self.executor.TimingExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author 张琪
 * @date 2022/11/24 14:38
 */
public class TimingExecutorImpl {
    private static final Logger log = LoggerFactory.getLogger(TimingExecutorImpl.class);

    public static void getCostTime(TimingExecutor executor) {
        try {
            long start = System.currentTimeMillis();
            executor.execute();
            long end = System.currentTimeMillis();
            log.info("当前任务耗时为: {}ms", end - start);
        } catch (Exception e) {
            log.error("计时任务执行异常");
            e.printStackTrace();
        }

    }

}
