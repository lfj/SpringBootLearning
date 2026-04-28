package com.lfj.demo.controller;

import com.lfj.demo.model.Girl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostGirlsController {

    private static final Logger logger = LoggerFactory.getLogger(PostGirlsController.class);

    @PostMapping(value = "/getGirlInfo4")
    public Girl getGirlInfo4(@RequestParam String params) {
        Girl girl = new Girl();
        girl.setId("4");
        girl.setName("liuyijun");
        girl.setAge(18);
        return girl;
    }

    @PostMapping(value = "/getGirlInfo5")
    public Girl getGirlInfo5(@RequestBody String params) {
        Girl girl = new Girl();
        girl.setId("5");
        girl.setName("yangqing");
        girl.setAge(12);
        return girl;
    }
}
