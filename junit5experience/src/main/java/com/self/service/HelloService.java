package com.self.service;

/**
 * @author 张琪
 * @version 1.0
 * @date 2021/4/13 15:18
 * @describe
 */
public interface HelloService {
    /**
     * 打招呼
     * @param name
     * @return
     */
    String hello(String name);

    /**
     * 数据增长
     * @param value
     * @return
     */
    int increase(int value);

    /**
     * 等待一秒后返回true
     * @return
     */
    boolean remoteRequest();
}
