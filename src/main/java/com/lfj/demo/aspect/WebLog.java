package com.lfj.demo.aspect;

import java.lang.annotation.*;

/**
 * Created by lfj-pc on 2019/7/28.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface WebLog {
    /**
     * 日志描述信息
     *
     * @return
     */
    String description() default "";
}
