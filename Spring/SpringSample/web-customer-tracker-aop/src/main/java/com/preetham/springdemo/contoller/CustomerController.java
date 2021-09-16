package com.preetham.springdemo.contoller;

import com.preetham.springdemo.dao.CustomerDAO;
import com.preetham.springdemo.entity.Customer;
import com.preetham.springdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    // need to inject service to the controller

    @Autowired
    private CustomerService customerService;

    @GetMapping("/list")
    public String listCustomers(Model theModel)
    {
        //get customers from service
        List<Customer> theCustomers = customerService.getCustomers();

        //add customers to the model
        theModel.addAttribute("customers",theCustomers);
        return "list-customers";
    }
    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel)
    {
        Customer customer = new Customer();

        theModel.addAttribute("customer",customer);
        return "customer-form";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer theCustomer)
    {
            //save the customer
            customerService.saveCustomer(theCustomer);
            return "redirect:/customer/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("customerId")int id,Model model)
    {
        //get the customer using the id
        Customer theCustomer = customerService.getCustomer(id);
        //set customer as a model to prepopulate the form
        model.addAttribute("customer",theCustomer);
        //send over to the form
        return "customer-form";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("customerId") int id)
    {
        customerService.deleteCustomer(id);
        return "redirect:/customer/list";
    }
}
