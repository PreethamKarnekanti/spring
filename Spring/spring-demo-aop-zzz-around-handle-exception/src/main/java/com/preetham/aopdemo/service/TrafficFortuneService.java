package com.preetham.aopdemo.service;

import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class TrafficFortuneService {
    public String getFortune()
    {
        try{
            TimeUnit.SECONDS.sleep(5);
        }catch(Exception e)
        {
            System.out.println(e);
        }
        return "Expect heavy traffic";
    }

    public String getFortune(boolean tripWire) {

        if(tripWire==true)
        {
            throw new RuntimeException("Major accident");
        }
        return getFortune();
    }
}
