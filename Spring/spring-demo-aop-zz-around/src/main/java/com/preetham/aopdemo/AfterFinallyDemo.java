package com.preetham.aopdemo;

import com.preetham.aopdemo.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterFinallyDemo {
    public static void main(String[] args) {
        //read the spring config file
        AnnotationConfigApplicationContext context =new AnnotationConfigApplicationContext(DemoConfig.class);
        //get the bean
        AccountDAO accountDAO = context.getBean(AccountDAO.class);

        //call the method

        List<Account> accounts=null;
        try {
            boolean tripWire = true;
            accountDAO.findAccounts(false);
        }catch (Exception e)
        {
            System.out.println("Exception CAught");
        }
        System.out.println(accounts);
        //close the context
        context.close();
    }
}
