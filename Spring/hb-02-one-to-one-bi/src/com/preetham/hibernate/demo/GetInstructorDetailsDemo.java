package com.preetham.hibernate.demo;

import com.preetham.hibernate.demo.entity.Instructor;
import com.preetham.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class GetInstructorDetailsDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                                    .addAnnotatedClass(Instructor.class)
                                    .addAnnotatedClass(InstructorDetail.class)
                                    .buildSessionFactory();
        Session session= factory.getCurrentSession();
        try
        {
            session.beginTransaction();
            // read the instructor details
            int id=29;
            InstructorDetail instructorDetail=session.get(InstructorDetail.class,id);
            System.out.println(instructorDetail);
            //retrieve assocaited instructor
            System.out.println("associated instructor: "+instructorDetail.getInstructor());
            session.getTransaction().commit();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally{
            session.close();
            factory.close();
        }
    }
}
