package com.luv2code.springboot.cruddemo.dao;

import com.luv2code.springboot.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDao{

    @Autowired
    EntityManager entityManager;
    @Override
    public List<Employee> findAll() {

        Query theQuery = entityManager.createQuery("from Employee",Employee.class);
        List<Employee> employeeList = theQuery.getResultList();
        return employeeList;
    }

    @Override
    public Employee getById(int theId) {
        Employee theEmployee = entityManager.find(Employee.class,theId);
        return theEmployee;
    }

    @Override
    public void save(Employee theEmployee) {
        Employee dbEmployee=entityManager.merge(theEmployee);
        theEmployee.setId(dbEmployee.getId());
    }

    @Override
    public void deleteById(int theId) {
        Query theQuery = entityManager.createQuery("delete from Employee where id="+theId);
        theQuery.executeUpdate();
    }
}
