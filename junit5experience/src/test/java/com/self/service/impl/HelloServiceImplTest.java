package com.self.service.impl;

import com.self.service.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * @author 张琪
 * @version 1.0
 * @date 2021/4/13 15:54
 * @describe
 */
@Slf4j
@SpringBootTest
public class HelloServiceImplTest {

    private final static String NAME = "pppoe";

    @Autowired
    HelloService helloService;

    /**
     * 所有程序执行前执行,(只执行一次) -- 在 beforeEach前
     */
    @BeforeAll
    public static void beforeAll(){
        log.warn("execute beforeAll");
    }

    /**
     * 所有程序执行后执行,(只执行一次) -- 在 afterEach后
     */
    @AfterAll
    public static void afterAll(){
        log.warn("execute afterAll");
    }

    /**
     * 每个程序执行前执行
     */
    @BeforeEach
    public void beforeEach(){
        log.info("execute beforeEach");

    }

    /**
     * 每个程序执行后执行
     */
    @AfterEach
    public void AfterEach(){
        log.info("execute afterEach");
    }

    @Test
    @DisplayName("测试service层的hello方法")
    public void hello(){
        log.info("hello");
        assertThat(helloService.hello(NAME)).isEqualTo("hello" + NAME);
    }

    @Test
    @DisplayName("测试service层的increase方法")
    public void increase(){
        log.debug("increase");
        assertThat(helloService.increase(1)).isEqualByComparingTo(2);
    }

    /**
     * 不会被执行的方法
     */
    @Test
    @Disabled
    public void neverExecute() {
        log.info("execute neverExecute");
    }

    /**
     * 调用一个耗时1s的方法, 超时时间为 500ms  因此不调用
     */
    @Test
    @Timeout(unit = TimeUnit.MILLISECONDS, value = 500)
    // @Disabled
    public void remoteRequest() {
        assertThat(helloService.remoteRequest()).isEqualTo(true);
    }

}
