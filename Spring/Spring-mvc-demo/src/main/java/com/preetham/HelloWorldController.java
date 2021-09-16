package com.preetham;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("/hello")
public class HelloWorldController {

    private HttpServletRequest request;

    @RequestMapping("/showForm")
    public String showForm()
    {
        return "helloWorld-form";
    }
    @RequestMapping("/processForm")
    public String processForm()
    {
        return "helloWorld";
    }

    @RequestMapping("/processFormVersionTwo")
    public String letsShout(HttpServletRequest request, Model model)
    {
        String name=request.getParameter("studentName");
        name=name.toUpperCase();
        String result= "yo! "+name;
        model.addAttribute("message",result);
        return "helloWorld";
    }
    @RequestMapping("/processFormVersionThree")
    public String processFormVersionThree(@RequestParam("studentName") String name, Model model)
    {
        name=name.toUpperCase();
        String result= "Hi ! "+name;
        model.addAttribute("message",result);
        return "helloWorld";
    }
}
