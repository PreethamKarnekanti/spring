package com.preetham.aopdemo;

import com.preetham.aopdemo.dao.AccountDAO;
import com.preetham.aopdemo.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AroundDemoApp {
    public static void main(String[] args) {
        //read the spring config file
        AnnotationConfigApplicationContext context =new AnnotationConfigApplicationContext(DemoConfig.class);
        //get the bean
        AccountDAO accountDAO = context.getBean(AccountDAO.class);
        TrafficFortuneService trafficFortuneService=context.getBean(TrafficFortuneService.class);

        //call the method
        System.out.println(trafficFortuneService.getFortune());

    }
}
