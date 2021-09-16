package com.luv2code.springboot.cruddemo.service;

import com.luv2code.springboot.cruddemo.dao.EmployeeDao;
import com.luv2code.springboot.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.*;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    private EmployeeDao employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDao employeeDAO){
        this.employeeDAO=employeeDAO;
    }
    @Override
    @Transactional
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }
    @Override
    @Transactional
    public Employee getById(int id) {
        return employeeDAO.getById(id);
    }
    @Override
    @Transactional
    public void save(Employee employee) {
        employeeDAO.save(employee);
    }
    @Override
    @Transactional
    public void deleteById(int id) {
        employeeDAO.deleteById(id);
    }

}
