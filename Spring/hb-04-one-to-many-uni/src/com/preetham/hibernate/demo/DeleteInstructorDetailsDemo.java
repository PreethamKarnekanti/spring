package com.preetham.hibernate.demo;

import com.preetham.hibernate.demo.entity.Instructor;
import com.preetham.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class DeleteInstructorDetailsDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                                    .addAnnotatedClass(Instructor.class)
                                    .addAnnotatedClass(InstructorDetail.class)
                                    .buildSessionFactory();
        Session session= factory.getCurrentSession();
        try
        {
            session.beginTransaction();
            int id=3;
            InstructorDetail instructorDetail=session.get(InstructorDetail.class,id);
            System.out.println(instructorDetail);
            //remove the associated object reference i.e;remove bidirectional link
            instructorDetail.getInstructor().setInstructorDetail(null);
            session.delete(instructorDetail);
            session.getTransaction().commit();
            System.out.println("Done!");
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
