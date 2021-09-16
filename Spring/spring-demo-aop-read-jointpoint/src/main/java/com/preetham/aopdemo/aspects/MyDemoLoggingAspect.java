package com.preetham.aopdemo.aspects;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    @Before("com.preetham.aopdemo.aspects.LuvAopExpressions.combinedPointCut()")
    public void beforeAddAccountAdvice()
    {
        System.out.println("------------------------executing before advice----------------");
    }

}
