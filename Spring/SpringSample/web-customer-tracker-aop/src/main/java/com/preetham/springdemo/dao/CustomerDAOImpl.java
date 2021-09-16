package com.preetham.springdemo.dao;

import com.preetham.springdemo.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO{

    //need to inject the hibernate session factory
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Customer> getCustomers() {
        //get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        //create query
        List<Customer> customers= currentSession.createQuery("from Customer order by lastName").list();
        System.out.println(customers);
        //execute query and get the result
        return customers;
    }

    @Override
    public void saveCustomer(Customer theCustomer) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(theCustomer);
    }

    @Override
    public Customer getCustomer(int id) {
        Session currentSession= sessionFactory.getCurrentSession();
        Customer theCustomer=currentSession.get(Customer.class,id);
        return theCustomer;
    }

    @Override
    public void deleteCustomer(int id) {
            Session session=sessionFactory.getCurrentSession();
            session.createQuery("delete from Customer where id="+id).executeUpdate();
    }
}
