package com.preetham.hibernate.demo;

import com.preetham.hibernate.demo.entity.Instructor;
import com.preetham.hibernate.demo.entity.InstructorDetail;
import com.preetham.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                                    .addAnnotatedClass(Instructor.class)
                                    .addAnnotatedClass(InstructorDetail.class)
                                    .buildSessionFactory();
        Session session= factory.getCurrentSession();
        try
        {
            Instructor instructor =new Instructor("Vyshnavi","k","sri@gmail.com");
            InstructorDetail instructorDetail = new InstructorDetail("www.youtube.com/food","eating");
            // associate objects
            instructor.setInstructorDetail(instructorDetail);
            session.beginTransaction();
            //save the instructor
            System.out.println(instructor);
            session.save(instructor);//this will also save details bcoz cascadetype.all

            session.getTransaction().commit();
            System.out.println("object saved");
        }
        finally{
            factory.close();
        }
    }
}
