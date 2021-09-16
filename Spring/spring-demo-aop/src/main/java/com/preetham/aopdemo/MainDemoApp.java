package com.preetham.aopdemo;

import com.preetham.aopdemo.dao.AccountDAO;
import com.preetham.aopdemo.dao.MemberShipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

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
        Boolean c=memberShipDAO.addMember();
        //close the context
        context.close();
    }
}
