package com.preetham.aopdemo.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LuvAopExpressions {

    @Pointcut("execution(* com.preetham.aopdemo.dao.*.*(..))")
   public void forDaoPackage(){}

    @Pointcut(("execution(* com.preetham.aopdemo.dao.*.get*(..))"))
    public void getter(){}

    @Pointcut(("execution(* com.preetham.aopdemo.dao.*.set*(..))"))
    public void setter(){}

    @Pointcut("forDaoPackage() && !(getter() || setter())")
    public void combinedPointCut(){}
}
