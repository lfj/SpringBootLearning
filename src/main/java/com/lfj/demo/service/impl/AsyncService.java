package com.lfj.demo.service.impl;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import static java.lang.System.out;

/**
 * 该service下的函数都是异步的函数
 */
@Service
public class AsyncService {

    @Async("lfjExecutor")
    public void getGirlInfoFromAbroad(String country) {
        out.println("fetch girl info from abroad!");
    }

}
