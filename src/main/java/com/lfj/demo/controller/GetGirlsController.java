package com.lfj.demo.controller;

import com.lfj.demo.aspect.Risk;
import com.lfj.demo.model.Girl;
import com.lfj.demo.service.IGirlService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/*
 * get girls info controller
 */
@RestController
public class GetGirlsController {

    private static final Logger logger = LoggerFactory.getLogger(PutGirlsController.class);

    @Value("${girl.id}")
    private String id;

    @Value("${girl.name}")
    private String girlName;

    @Value("${girl.age}")
    private int girlAge;

    @Resource
    private IGirlService girlService;

    @RequestMapping(value = "/getGirlInfo1", method = RequestMethod.GET)
    @Risk
    public Girl getGirlInfo1() throws Exception{
        int i = 1 / 0;
        return girlService.getGirlsInfo();
    }

    @GetMapping("/getGirlInfo2")
    public Girl getGirlInfo2(@RequestParam(value = "name", required = false) String name) {
        Girl girl = new Girl();
        girl.setId("2");
        girl.setName("momoko");
        girl.setAge(28);
        return girl;
    }

    @GetMapping(value = "/getGirlInfo3/{id}")
    public Girl getGirlInfo3(@PathVariable(value = "id", required = false) String id) {
        Girl girl = new Girl();
        girl.setId("3");
        girl.setName("unknown girl");
        girl.setAge(26);
        return girl;
    }
}
