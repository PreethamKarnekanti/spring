package com.preetham;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnoDemoApp {
    public static void main(String[] args) {
        //reading the config file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        //retrieving the bean
        Coach theCoach = context.getBean("tennisCoach",Coach.class);

        Coach myCoach = context.getBean("tennisCoach",Coach.class);

        System.out.println(theCoach.getDailyWorkout());

        System.out.println(theCoach.getDailyFortune());

        System.out.println(theCoach);
        context.close();
    }
}
