package com.self.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

/**
 * @author 张琪
 * @version 1.0
 * @date 2021/4/13 18:08
 * @describe
 */
@SpringBootTest
@Slf4j
@ActiveProfiles("test")
class AssumptionsTest {

    @Value("${envType}")
    public String envType;

    /**
     * 最简单的成功用例
     */
    @Test
    @DisplayName("断定成功测试方法")
    void assertSuccess() {
        assertEquals(2, Math.addExact(1,1));
    }

    /**
     * 最简单的失败用例
     */
    @Test
    @DisplayName("断定失败测试方法")
    void assertFail() {
        assertEquals(3, Math.addExact(1,1));
    }

    /**
     * assumeTrue不抛出异常的用例
     */
    @Test
    void assumpSuccess() {
        // assumeTrue方法的入参如果为true，就不会抛出异常，后面的代码才会继续执行
        assumeTrue(true);
        // 如果打印出此日志，证明assumeTrue方法没有抛出异常
        log.info("assumpSuccess的assumeTrue执行完成");
        // 接下来是常规的单元测试逻辑
        assertEquals(2, Math.addExact(1,1));
    }

    /**
     * assumeTrue抛出异常的用例
     */
    @Test
    void assumpFail() {
        // assumeTrue方法的入参如果为false，就会抛出TestAbortedException异常，后面就不会执行了
        assumeTrue(false);
        // 如果打印出此日志，证明assumpFail方法没有抛出异常
        log.info("assumpFail的assumeTrue执行完成");
        // 接下来是常规的单元测试逻辑，但因为前面抛出了异常，就不再执行了
        assertEquals(2, Math.addExact(1,1));
    }

    @Test
    @DisplayName("普通assume用法")
    void tryAssumeTrue(){
        assumeTrue("CI".equals(envType));
        log.info("CI环境才会打印assumeTrue");
        assertEquals(2, Math.addExact(1,1));
    }

    @Test
    @DisplayName("assume失败时带自定义错误信息")
    void tryAssumeTrueWithMessage() {
        // 当第二个参数报错时, 返回第一个参数表示的字符串信息
        assumeTrue("DI".equals(envType),
                () -> "环境不匹配而跳过，当前环境：" + envType);

        log.info("CI环境才会打印的tryAssumeTrueWithMessage");
    }

    @Test
    void tryAssumingThat(){
        // assumingThat 前一个参数为false时, 不会抛出异常
        assumingThat("DI".equals(envType), () -> {
            log.info("只能在环境为CI时打印");
        });
        log.info("无论什么环境都会打印的tryAssumingThat");
    }

}
