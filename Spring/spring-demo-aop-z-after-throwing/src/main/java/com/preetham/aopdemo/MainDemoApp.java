package com.preetham.aopdemo;

import com.preetham.aopdemo.dao.AccountDAO;
import com.preetham.aopdemo.dao.MemberShipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MainDemoApp {
    public static void main(String[] args) {
        //read the spring config file
        AnnotationConfigApplicationContext context =new AnnotationConfigApplicationContext(DemoConfig.class);
        //get the bean
        AccountDAO accountDAO = context.getBean(AccountDAO.class);
        MemberShipDAO memberShipDAO= context.getBean(MemberShipDAO.class);
        //call the method
        Account account = new Account();
        accountDAO.addAccount(account,true);
        accountDAO.doWork();
        accountDAO.setName("foBar");
        accountDAO.setServiceCode("dadsa");
        String name = accountDAO.getName();
        String serviceCode= accountDAO.getServiceCode();
        Boolean c=memberShipDAO.addMember();
        List<Account> accounts= accountDAO.findAccounts(false);
        System.out.println(accounts);
        //close the context
        context.close();
    }
}
