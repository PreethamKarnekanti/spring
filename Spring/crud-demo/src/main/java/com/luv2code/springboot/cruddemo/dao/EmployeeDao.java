package com.luv2code.springboot.cruddemo.dao;

import com.luv2code.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDao {
    public List<Employee> findAll();
    Employee getById(int theId);
    void save(Employee theEmployee);
    void deleteById(int theId);


}
