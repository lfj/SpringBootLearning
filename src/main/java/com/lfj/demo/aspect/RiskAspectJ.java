package com.lfj.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class RiskAspectJ  {

    private static final Logger logger = LoggerFactory.getLogger(RiskAspectJ.class);

    /**
     * 切点 带有Risk注解的所有方法
     */
    @Pointcut("@annotation(risk)")
    public void riskPointcut(Risk risk) {
        int i= 0;
    }

    /**
     * 拦截所有指定需要处理风控逻辑的接口
     */
    @Before(value = "riskPointcut(risk)", argNames = "joinPoint,risk")
    public void doRiskTask(JoinPoint joinPoint, Risk risk) throws Exception {
        int j = 0;
    }

    @After(value = "riskPointcut(risk)", argNames = "joinPoint,risk")
    public void afterDoRiskTask(JoinPoint joinPoint, Risk risk) throws Exception {
        int j = 0;
    }

    @Around(value = "riskPointcut(risk)")
    public void watch(ProceedingJoinPoint jp, Risk risk) {
        try {
            System.out.println("perpare for the coming war!");
            jp.proceed();
            System.out.println("recover the economy which are damaged by the war!");
        } catch (Throwable e) {
            logger.error(this.getClass().getName(), e);
        }
    }

    @AfterReturning(value = "riskPointcut(risk)")
    public void afterReturn(JoinPoint jp, Risk risk) {
        System.out.println("The result return!");
    }

    @AfterThrowing(value = "riskPointcut(risk)")
    public void afterThrowException(JoinPoint jp, Risk risk) {
        System.out.println("The exception has been throwed!");
    }
}

