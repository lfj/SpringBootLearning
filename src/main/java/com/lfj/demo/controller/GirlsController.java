package com.lfj.demo.controller;

import com.lfj.demo.model.Girl;
import org.springframework.web.bind.annotation.*;

@RestController
public class GirlsController {

    @RequestMapping(value = "/getGirlInfo", method = RequestMethod.GET)
    public Girl getGirlInfo() {
        Girl girl = new Girl();
        girl.setId("1");
        girl.setName("lyp");
        girl.setAge(21);
        return girl;
    }

    @PutMapping("/addGirlInfo")
    public Girl addGirlInfo(Girl girl) {
        if (null != girl) {
            System.out.println(girl.getName() + girl.getAge());
        }
        return girl;
    }
}
