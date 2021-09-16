package com.luv2code.springsecurity.demo.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

@Component
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //add the users
        User.UserBuilder userBuilder=User.withDefaultPasswordEncoder();
        auth.inMemoryAuthentication()
                .withUser(userBuilder.username("john").password("test123").roles("EMPLOYEE"))
                .withUser(userBuilder.username("mary").password("test123").roles("MANAGER"))
                .withUser(userBuilder.username("susan").password("test123").roles("ADMIN"));
    }
}
