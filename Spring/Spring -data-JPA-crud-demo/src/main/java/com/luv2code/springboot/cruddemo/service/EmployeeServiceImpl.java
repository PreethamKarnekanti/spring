package com.luv2code.springboot.cruddemo.service;

import com.luv2code.springboot.cruddemo.dao.EmployeeRepository;
import com.luv2code.springboot.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.*;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    private EmployeeRepository employeeRepository;


    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }
    @Override
    public Employee getById(int id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if(employee.isPresent())
            return employee.get();
        throw new RuntimeException("No employee Found with ID"+id);
    }
    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }
    @Override
    public void deleteById(int id) {
        employeeRepository.deleteById(id);
    }

}
