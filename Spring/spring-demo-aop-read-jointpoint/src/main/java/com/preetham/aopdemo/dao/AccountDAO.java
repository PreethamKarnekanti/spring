package com.preetham.aopdemo.dao;

import com.preetham.aopdemo.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

    private String name;
    private String serviceCode;
    public void addAccount(Account account , boolean theVip)
    {
        System.out.println(getClass()+"Adding the account");
    }
    public void doWork()
    {
        System.out.println("doing work");
    }

    public String getName() {
        System.out.println("AccountDAO.getName");
        return name;
    }

    public void setName(String name) {
        System.out.println("AccountDAO.setName");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println("AccountDAO.getServiceCode");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println("AccountDAO.setServiceCode");
        this.serviceCode = serviceCode;
    }
}
