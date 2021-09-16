package com.preetham.aopdemo.aspects;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {


    @Before("execution(public void addAccount())")
    public void beforeAddAccountAdvice()
    {
        System.out.println("------------------------executing before advice----------------");
    }

}
