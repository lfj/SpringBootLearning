package com.lfj.demo.aspect;

import java.lang.annotation.*;

@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Risk {
    //RiskTypeEnum value();
}
