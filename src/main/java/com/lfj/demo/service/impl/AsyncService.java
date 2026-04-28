package com.lfj.demo.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import static java.lang.System.out;

/**
 * 该service下的函数都是异步的函数
 * 如果要使能异步方法，除了方法上得加入@Async注解，最初的启动类上也要加入@EnableAsync以使能
 */
@Service
public class AsyncService {

    private static final Logger logger = LoggerFactory.getLogger(AsyncService.class);

    @Async("lfjExecutor")
    public void getGirlInfoFromAbroad(String country) {
        logger.info("异步方法已经被调用！");
    }
}
