package com.preetham.hibernate.demo;

import com.preetham.hibernate.demo.entity.Course;
import com.preetham.hibernate.demo.entity.Instructor;
import com.preetham.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class DeleteCoursesDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                                    .addAnnotatedClass(Instructor.class)
                                    .addAnnotatedClass(InstructorDetail.class)
                                    .addAnnotatedClass(Course.class)
                                    .buildSessionFactory();
        Session session= factory.getCurrentSession();
        try
        {
            session.beginTransaction();
            //get the instrucotr from the db
            int id=1;

            session.createQuery("delete from Course where id=10").executeUpdate();
            session.getTransaction().commit();
            System.out.println("object saved");
        }
        finally{
            session.close();
            factory.close();
        }
    }
}
