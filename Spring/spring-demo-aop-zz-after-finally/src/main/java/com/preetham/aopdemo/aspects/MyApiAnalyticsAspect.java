package com.preetham.aopdemo.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyApiAnalyticsAspect {
    @Before("com.preetham.aopdemo.aspects.LuvAopExpressions.combinedPointCut()")
    public void performApiAnalytics()
    {
        System.out.println("-------Performing api analytics");
    }
}
