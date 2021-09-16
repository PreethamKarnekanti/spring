package com.luv2code.springsecurity.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/showLoginPage")
    public String showLoginPage()
    {
        return "bootstrappage";
    }
    @GetMapping("/access-denied")
    public String showAccessDeniedPage()
    {
        return "accessDenied";
    }
}
