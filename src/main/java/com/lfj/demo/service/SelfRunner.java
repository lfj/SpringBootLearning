package com.lfj.demo.service;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * Created by lfj-pc on 2019/7/27.
 */
@Component
public class SelfRunner implements ApplicationRunner{

    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        System.out.print("What do you want to do!");
    }
}
