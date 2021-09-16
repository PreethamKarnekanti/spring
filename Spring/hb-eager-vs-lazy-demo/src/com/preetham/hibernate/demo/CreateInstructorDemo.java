package com.preetham.hibernate.demo;

import com.preetham.hibernate.demo.entity.Course;
import com.preetham.hibernate.demo.entity.Instructor;
import com.preetham.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateInstructorDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                                    .addAnnotatedClass(Instructor.class)
                                    .addAnnotatedClass(InstructorDetail.class)
                                    .addAnnotatedClass(Course.class)
                                    .buildSessionFactory();
        Session session= factory.getCurrentSession();
        try
        {
            Instructor instructor =new Instructor("Preetham","k","pree@gmail.com");
            InstructorDetail instructorDetail = new InstructorDetail("www.youtube.com/","playing");

            instructor.setInstructorDetail(instructorDetail);

            session.beginTransaction();
            System.out.println(instructor);
            session.save(instructor);//this will also save details bcoz cascadetype.all

            session.getTransaction().commit();
            System.out.println("object saved");
        }
        finally{
            session.close();
            factory.close();
        }
    }
}
