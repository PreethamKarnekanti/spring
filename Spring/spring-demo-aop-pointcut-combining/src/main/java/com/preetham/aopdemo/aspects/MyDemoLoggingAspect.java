package com.preetham.aopdemo.aspects;


import com.preetham.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

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
