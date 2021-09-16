package com.preetham.aopdemo.aspects;


import com.preetham.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Locale;
import java.util.logging.Logger;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    Logger myLogger= Logger.getLogger(getClass().getName());
    @Around("execution(* com.preetham.aopdemo.service.TrafficFortuneService.getFortune(..))")
    public Object aroundGetFortune(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable
    {
        myLogger.info(""+theProceedingJoinPoint.getSignature());
        long begin=System.currentTimeMillis();
        Object result = theProceedingJoinPoint.proceed();
        long end=System.currentTimeMillis();
        long duration = end- begin;
        myLogger.info("Duration"+duration/1000+"seconds");
        return result;

    }
    @After("execution(* com.preetham.aopdemo.dao.AccountDAO.findAccounts(..))")
    public void afterFinally(JoinPoint joinPoint)
    {
        myLogger.info(""+joinPoint.getSignature());
        myLogger.info("MyDemoLoggingAspect.afterFinally");
    }
    @AfterThrowing(pointcut="execution(* com.preetham.aopdemo.dao.AccountDAO.findAccounts(..))",throwing = "theExc")
    public void afterThrowingFindAccount(JoinPoint theJoinPoint, Throwable theExc)
    {
        myLogger.info(""+theJoinPoint.getSignature());
        myLogger.info(""+theExc);
    }

    @AfterReturning(pointcut="execution(* com.preetham.aopdemo.dao.AccountDAO.findAccounts(..))", returning="result")
    public void afterRunningFindAccountAdvice(JoinPoint theJoinPoint, List<Account> result)
    {
        String method=theJoinPoint.getSignature().toShortString();
        myLogger.info("executing  after returning"+method);
        myLogger.info(""+result);
        toUppercase(result);
        myLogger.info(""+result);
    }

    private void toUppercase(List<Account> result) {
        for(Account tempAccount : result)
        {
            String upperName = tempAccount.getName().toUpperCase();
            tempAccount.setName(upperName);
        }
    }


    @Before("com.preetham.aopdemo.aspects.LuvAopExpressions.combinedPointCut()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint)
    {
        MethodSignature methodSignature =(MethodSignature)joinPoint.getSignature();
        Object[] args= joinPoint.getArgs();
        myLogger.info("method"+methodSignature);

        for(Object temp :args) {
            if(temp instanceof Account)
                myLogger.info(((Account) temp).getName()+"  "+((Account) temp).getLevel());
            myLogger.info(""+temp);
        }
        myLogger.info("------------------------executing before advice----------------");
    }

}
