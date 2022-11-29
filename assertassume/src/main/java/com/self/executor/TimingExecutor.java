package com.self.executor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 用于计时的执行器
 * @author 张琪
 * @date 2022/11/24 14:36
 */
@FunctionalInterface
public interface TimingExecutor {
    /**
     * 用于计时的方法
     * @throws Exception 计时方法抛出的异常
     */
    void execute() throws Exception;
}
