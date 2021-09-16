package com.preetham.hibernate.demo;

import com.preetham.hibernate.demo.entity.Course;
import com.preetham.hibernate.demo.entity.Instructor;
import com.preetham.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class GetInstructorCoursesDemo {
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
            Instructor instructor= session.get(Instructor.class ,id);
            System.out.println(instructor);
            System.out.println(instructor.getCourses());
            session.getTransaction().commit();
            System.out.println("object saved");
        }
        finally{
            session.close();
            factory.close();
        }
    }
}
