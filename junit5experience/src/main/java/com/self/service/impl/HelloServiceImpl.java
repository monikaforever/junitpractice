package com.self.service.impl;

import com.self.service.HelloService;
import org.springframework.stereotype.Service;

/**
 * @author 张琪
 * @version 1.0
 * @date 2021/4/13 15:41
 * @describe
 */
@Service
public class HelloServiceImpl implements HelloService {

    @Override
    public String hello(String name) {
        return "hello" + name;
    }

    @Override
    public int increase(int value) {
        return value + 1;
    }

    @Override
    public boolean remoteRequest() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
