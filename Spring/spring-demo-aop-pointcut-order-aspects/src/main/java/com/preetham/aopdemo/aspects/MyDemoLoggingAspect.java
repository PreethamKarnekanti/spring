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

    @Pointcut(("execution(* com.preetham.aopdemo.dao.*.get*(..))"))
    private void getter(){}

    @Pointcut(("execution(* com.preetham.aopdemo.dao.*.set*(..))"))
    private void setter(){}

    @Pointcut("forDaoPackage() && !(getter() || setter())")
    private void combinedPointCut(){}

    @Before("combinedPointCut()")
    public void beforeAddAccountAdvice()
    {
        System.out.println("------------------------executing before advice----------------");
    }
    @Before("combinedPointCut()")
    public void performApiAnalytics()
    {
        System.out.println("-------Performing api analytics");
    }
}
