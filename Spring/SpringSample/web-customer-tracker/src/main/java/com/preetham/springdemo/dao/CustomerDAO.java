package com.preetham.springdemo.dao;

import com.preetham.springdemo.entity.Customer;

import java.util.List;

public interface CustomerDAO {
    public List<Customer> getCustomers();

    void saveCustomer(Customer theCustomer);

    public Customer getCustomer(int id);

    void deleteCustomer(int id);
}
