package com.preetham.aopdemo.dao;

import com.preetham.aopdemo.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

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

    public List<Account> findAccounts(boolean tripWire)
    {
        System.out.println("called fromsample");
        if(tripWire==true)
        {
            throw new RuntimeException("No soup");
        }
        List<Account> myAccounts = new ArrayList<>();
        myAccounts.add(new Account("preetham","platinum"));
        myAccounts.add(new Account("ranadheer","gold"));
        myAccounts.add(new Account("lallu","gold"));
        return myAccounts;
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
