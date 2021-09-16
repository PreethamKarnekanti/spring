package com.preetham.aopdemo.dao;

import com.preetham.aopdemo.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountDAO {


    public void addAccount(Account account , boolean theVip)
    {
        System.out.println(getClass()+"Adding the account");
    }
    public void doWork()
    {
        System.out.println("doing work");
    }
}
