package com.preetham.aopdemo.aspects;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {


    @Pointcut("execution(* com.preetham.aopdemo.dao.*.*(..))")
    private void forDaoPackage(){}

    @Before("forDaoPackage()")
    public void beforeAddAccountAdvice()
    {
        System.out.println("------------------------executing before advice----------------");
    }
    @Before("forDaoPackage()")
    public void performApiAnalytics()
    {
        System.out.println("-------Performing api analytics");
    }
}
