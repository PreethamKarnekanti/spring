package com.luv2code.springsecurity.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {
    @GetMapping("/")
    public String showHome()
    {
        return "home";
    }

    @GetMapping("/managers")
    public String showManager()
    {
        return "manager";
    }
     @GetMapping("/admins")
    public String showAdmin()
     {
         return "admin";
     }
}
