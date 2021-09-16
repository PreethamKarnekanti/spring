package com.preetham;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class TennisCoach implements Coach{
    @Autowired
    @Qualifier("randomFortuneService")
    private FortuneService fortuneService;

   /* @Autowired constructor injection
   public TennisCoach(FortuneService fortuneService)
    {
        this.fortuneService=fortuneService;
    }
    @Autowired //setter injection
    public void setFortuneService()
    {
        this.fortuneService=fortuneService
    }
*/
    @PostConstruct
    public void init()
    {
        System.out.println("init method");
    }
    @PreDestroy
    public void destroy()
    {
        System.out.println("destroy method");
    }
    @Override
    public String getDailyWorkout() {
        return "Practice your backhand";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
