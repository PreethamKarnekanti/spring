package com.preetham.springdemo.service;

import com.preetham.springdemo.entity.Customer;

import java.util.List;

public interface CustomerService {
    public List<Customer> getCustomers();

    void saveCustomer(Customer theCustomer);

    public Customer getCustomer(int id);

    void deleteCustomer(int id);
}
