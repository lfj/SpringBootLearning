package com.lfj.demo.controller;

import com.lfj.demo.model.Girl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * the controller is used to add girl info
 */
@RestController
public class PutGirlsController {

    private static final Logger logger = LoggerFactory.getLogger(PutGirlsController.class);

    @RequestMapping(value="/addGirlInfo1", method= RequestMethod.PUT)
    public Girl addGirlInfo1(@RequestBody Girl girl) {
        if (null != girl) {
            logger.info("name = {}, age = {}", girl.getName(), girl.getAge());
        }
        return girl;
    }

    /**
     * 参数里加入@RequestBody说明是http请求的body体里，如果不加入@RequestBody说明是放在url后
     * @param girl
     * @return
     */
    @PutMapping("/addGirlInfo2")
    public Girl addGirlInfo2(@RequestBody Girl girl) {
        if (null != girl) {
            logger.info("name = {}, age = {}", girl.getName(), girl.getAge());
        }
        return girl;
    }

    @PutMapping("/addGirlInfo3")
    public Girl addGirlInfo3(@Valid Girl girl, BindingResult result) {
        if (result.hasErrors()) {
            ObjectError firstError = result.getAllErrors().get(0);
            return null;
        }
        logger.info("name = {}, age = {}", girl.getName(), girl.getAge());
        return girl;
    }
}
