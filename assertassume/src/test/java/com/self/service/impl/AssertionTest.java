package com.self.service.impl;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author 张琪
 * @date 2022/11/24 16:42
 */
public class AssertionTest {
    private static final Logger log = LoggerFactory.getLogger(AssertionTest.class);

    @Test
    @DisplayName("最普通的判断")
    void standardTest() {
        assertEquals(2, Math.addExact(1, 1));
    }

    @Test
    @DisplayName("带失败提示的判断(拼接消息字符串的代码只有判断失败时才执行)")
    void assertWithLazilyRetrievedMessage() {
        int expected = 2;
        int actual = 1;

        // 如果 expected == actual, 则不会打印第三个参数的内容
        assertEquals(expected, actual, ()->
                String.format("期望值[%d], 实际值[%d]", expected, actual)
        );
    }

    @Test
    @DisplayName("批量判断(必须全部通过, 否则失败)")
    void groupedAssertion() {
        // 第一个的参数信息最后附加在异常信息上
        assertAll("单个测试方法多次判断",
                () -> assertEquals(1,1),
                () -> assertEquals(2,1),
                () -> assertEquals(3,1)
        );
    }

    @Test
    @DisplayName("判断抛出的异常类型, 判断对则不抛出异常")
    void exceptionTesting() {
        // 断言抛出的异常
        Exception exception = assertThrows(ArithmeticException.class, () -> Math.floorDiv(1, 0));
        log.info("assertThrows通过后，返回的异常实例：{}", exception.getMessage());
    }

    @Test
    @DisplayName("指定时间内完成测试")
    void timeoutExecuted() {
        // 超市后执行第二个参数
        String s = assertTimeout(Duration.ofSeconds(2), () -> "2222");

        System.out.println(s);
    }

}
