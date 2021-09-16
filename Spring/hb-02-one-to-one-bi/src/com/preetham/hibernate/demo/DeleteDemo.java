package com.preetham.hibernate.demo;

import com.preetham.hibernate.demo.entity.Instructor;
import com.preetham.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class DeleteDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                                    .addAnnotatedClass(Instructor.class)
                                    .addAnnotatedClass(InstructorDetail.class)
                                    .buildSessionFactory();
        Session session= factory.getCurrentSession();
        try
        {
            int id=1;
            session.beginTransaction();
            Instructor instructor = session.get(Instructor.class,id);
            if(instructor!=null)
                session.delete(instructor); // alsodelets the associated details object
            session.getTransaction().commit();
            System.out.println("obj deleted");
        }
        finally{
            factory.close();
        }
    }
}
