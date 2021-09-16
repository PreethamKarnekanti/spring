package com.preetham;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:sports.properties")
// @ComponentScan("com.preetham")
public class SportConfig {

    @Bean
    public FortuneService sadFortuneService()
    {
        return new SadFortuneService();
    }
    @Bean
    public Coach mySwimCoach()
    {
        Coach theCoach = new SwimCoach(sadFortuneService());
        return theCoach;
    }
}

