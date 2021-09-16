package com.preetham.hibernate.demo;

import com.preetham.hibernate.demo.entity.Course;
import com.preetham.hibernate.demo.entity.Instructor;
import com.preetham.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateCoursesDemo {
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
            Instructor instructor= session.get(Instructor.class,id);

            //create some courses
            Course course1 = new Course("DesignPattern");
            Course course2= new Course("Programing through C");

            //add courses to the instructor
            instructor.add(course1);
            instructor.add(course2);
            //save the courses
            session.save(course1);
            session.save(course2);
            session.getTransaction().commit();
            System.out.println("object saved");
        }
        finally{
            session.close();
            factory.close();
        }
    }
}
