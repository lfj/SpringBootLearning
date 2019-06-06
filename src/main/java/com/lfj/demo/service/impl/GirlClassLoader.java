package com.lfj.demo.service.impl;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component("girlClassLoader")
public class GirlClassLoader implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public <T> Map<String, T> getBeansOfType(Class<T> clazz) {
        return applicationContext.getBeansOfType(clazz);
    }
}
