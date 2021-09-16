package com.preetham.aopdemo.dao;

import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
public class MemberShipDAO {

    @Before("execution(public void addCustomer())")
    public Boolean addMember()
    {
        System.out.println(getClass()+"Adding membership account");
        return false;
    }
}
