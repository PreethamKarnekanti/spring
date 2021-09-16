package com.preetham.hibernate.demo;

import com.preetham.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
        Session session= factory.getCurrentSession();
        try
        {
            Student tempStudent1 = new Student("Ranadheer","B","abcd@gmail.com");
            Student tempStudent2 = new Student("Srivyshnavi","k","def@gmail.com");
            Student tempStudent3 = new Student("Abhilash","B","ijkl@gmail.com");
            session.beginTransaction();
            session.save(tempStudent1);
            session.save(tempStudent2);
            session.save(tempStudent3);
            session.getTransaction().commit();
            System.out.println("objects saved");
        }
        finally{
            factory.close();
        }
    }
}
