package com.self.executor.impl;

import cn.hutool.core.io.resource.ResourceUtil;
import org.junit.jupiter.api.Test;

import static com.self.executor.impl.TimingExecutorImpl.getCostTime;

/**
 * @author 张琪
 * @date 2022/11/24 15:32
 */
class TimingExecutorImplTest {

    /**
     * 测试 Hutools中的ResourceUtil工具类 与 class.getResource() 获取绝对路径的速度
     */
    @Test
    public void testGetCostTime() {

        getCostTime(
                () -> TimingExecutorImpl.class.getResource("/").getPath()
        );

        getCostTime(
                () -> ResourceUtil.getResource("").getPath()
        );
    }

}
