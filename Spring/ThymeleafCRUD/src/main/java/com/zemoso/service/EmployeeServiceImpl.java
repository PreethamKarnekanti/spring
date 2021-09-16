package com.zemoso.service;

import com.zemoso.entity.Employee;
import com.zemoso.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository){
        this.employeeRepository=employeeRepository;
    }
    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAllByOrderByLastNameAsc();
    }
    @Override
    public Employee findById(int id) {
        Optional<Employee> employee=employeeRepository.findById(id);
        if(employee.isPresent())
            return employee.get();
        throw new RuntimeException("Employee Not Found:"+id);
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
