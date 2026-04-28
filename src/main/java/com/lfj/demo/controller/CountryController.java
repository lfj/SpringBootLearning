package com.lfj.demo.controller;

import com.lfj.demo.model.Girl;
import com.lfj.demo.service.IGirlService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

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

    @PostMapping("/otel")
    public void ceshiotel(@RequestBody(required = false) String params, HttpServletRequest request) {
        System.out.println("已被调用params=" + params);
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            String headerValue = request.getHeader(headerName);
            System.out.println("Header: " + headerName + " = " + headerValue);
        }
    }
}
