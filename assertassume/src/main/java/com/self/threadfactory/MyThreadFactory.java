package com.self.threadfactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ThreadFactory;

/**
 * @author 张琪
 * @date 2022/11/28 17:37
 */
public class MyThreadFactory implements ThreadFactory {
    private static final Logger log = LoggerFactory.getLogger(MyThreadFactory.class);

    @Override
    public Thread newThread(Runnable r) {
        return null;
    }
}
