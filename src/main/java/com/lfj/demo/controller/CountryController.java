package com.lfj.demo.controller;

import com.lfj.demo.model.Girl;
import com.lfj.demo.service.IGirlService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class CountryController {

    private static final Logger logger = LoggerFactory.getLogger(CountryController.class);

    @Resource
    private IGirlService girlService;

    @GetMapping("/isDevelopedCountry")
    public void isDevelopedCountry() {
        girlService.initCountryServiceList();
        girlService.doCountry();
    }

}
