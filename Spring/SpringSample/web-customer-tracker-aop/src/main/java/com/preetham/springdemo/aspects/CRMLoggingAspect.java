package com.preetham.springdemo.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class CRMLoggingAspect {
    private Logger logger=Logger.getLogger(getClass().getName());

    @Pointcut("execution=com.preetham.springdemo.controller.*.*(..))")
    private void forControllerPackage(){}

    @Pointcut("execution=com.preetham.springdemo.service.*.*(..))")
    private void forServicePackage(){}

    @Pointcut("execution=com.preetham.springdemo.dao.*.*(..))")
        private void forDaoPackage(){}

    @Pointcut("forDaoPackage() ||  forServicePackage() || forControllerPackage()")
    private void forAppFlow(){}

    @Before("forAppFlow()")
    public void before(JoinPoint joinPoint){
        logger.info("===> in @Before Called"+joinPoint.getSignature());
        Object[] args=joinPoint.getArgs();
        for(Object temp: args)
            logger.info("===>"+temp);
    }
    @AfterReturning(pointcut = "forAppFlow()",returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result){
        logger.info("===> in @After Returning Called"+joinPoint.getSignature());
        logger.info("===>Result:"+result);
    }
}
