package com.luv2code.springboot.cruddemo.dao;

import com.luv2code.springboot.cruddemo.entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import java.util.List;

@Repository
public class EmployeeDaoHibernateImpl implements EmployeeDao{
    //define field for entity manager
    private EntityManager entityManager;

    //constructor injection
    @Autowired
    public EmployeeDaoHibernateImpl(EntityManager entityManager)
    {
        this.entityManager=entityManager;
    }


    @Override
    public List<Employee> findAll() {
        // get the current hibernate session
        Session currentSession= entityManager.unwrap(Session.class);
        // create the query and get result list
         Query theQuery= currentSession.createQuery("from Employee",Employee.class);

         List<Employee> employeeList = theQuery.getResultList();
        //return list

        return employeeList;
    }
    @Override
    public Employee getById(int theId) {
        Session currentSession = entityManager.unwrap(Session.class);
        Employee theEmployee =
                currentSession.get(Employee.class, theId);
        return theEmployee;
    }
    @Override
    public void save(Employee theEmployee) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(theEmployee);
    }
    @Override
    public void deleteById(int theId) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query theQuery =
                currentSession.createQuery(
                        "delete from Employee where id=:employeeId");
        theQuery.setParameter("employeeId", theId);
        theQuery.executeUpdate();
    }
}
