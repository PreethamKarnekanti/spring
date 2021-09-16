package com.preetham;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomFortuneService implements FortuneService{

    private String[] data ={
            "Hello","Beware","Cricket"
    };

    private Random myRandom = new Random();
    @Override
    public String getFortune() {
        int index = myRandom.nextInt(data.length);
        return data[index];
    }
}
