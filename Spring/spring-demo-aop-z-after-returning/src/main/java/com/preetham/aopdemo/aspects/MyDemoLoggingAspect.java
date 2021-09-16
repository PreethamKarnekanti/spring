package com.preetham.aopdemo.aspects;


import com.preetham.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Locale;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    @AfterReturning(pointcut="execution(* com.preetham.aopdemo.dao.AccountDAO.findAccounts(..))", returning="result")
    public void afterRunningFindAccountAdvice(JoinPoint theJoinPoint, List<Account> result)
    {
        String method=theJoinPoint.getSignature().toShortString();
        System.out.println("executing  after returning"+method);
        System.out.println(result);
        toUppercase(result);
        System.out.println(result);
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
        System.out.println("method"+methodSignature);

        for(Object temp :args) {
            if(temp instanceof Account)
                System.out.println(((Account) temp).getName()+"  "+((Account) temp).getLevel());
            System.out.println(temp);
        }
        System.out.println("------------------------executing before advice----------------");
    }

}
