package com.preetham;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class HelloSpringApp {
    public static void main(String[] args){
        ClassPathXmlApplicationContext context =new ClassPathXmlApplicationContext("applicationContext.xml");
        Coach theCoach= context.getBean("myCoach",Coach.class);
        System.out.println(theCoach.getDailyWorkout());
        System.out.println(theCoach.getDailyFortune());
        Coach newCoach = context.getBean("myCoach",Coach.class);

        System.out.println(theCoach);
        System.out.println(newCoach);
        context.close();
    }
}
