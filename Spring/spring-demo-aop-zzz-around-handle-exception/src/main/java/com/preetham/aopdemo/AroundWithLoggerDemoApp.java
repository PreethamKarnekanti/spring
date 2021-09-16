package com.preetham.aopdemo;

import com.preetham.aopdemo.dao.AccountDAO;
import com.preetham.aopdemo.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;

public class AroundWithLoggerDemoApp {
    private static Logger myLogger = Logger.getLogger(AroundWithLoggerDemoApp.class.getName());
    public static void main(String[] args) {
        //read the spring config file
        AnnotationConfigApplicationContext context =new AnnotationConfigApplicationContext(DemoConfig.class);
        //get the bean
        AccountDAO accountDAO = context.getBean(AccountDAO.class);
        TrafficFortuneService trafficFortuneService=context.getBean(TrafficFortuneService.class);

        //call the method
       myLogger.info(trafficFortuneService.getFortune());

    }
}
