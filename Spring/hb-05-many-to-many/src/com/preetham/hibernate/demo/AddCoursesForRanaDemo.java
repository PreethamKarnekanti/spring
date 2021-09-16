package com.preetham.hibernate.demo;

import com.preetham.hibernate.demo.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class AddCoursesForRanaDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                                    .addAnnotatedClass(Instructor.class)
                                    .addAnnotatedClass(InstructorDetail.class)
                                    .addAnnotatedClass(Course.class)
                                    .addAnnotatedClass(Review.class)
                                    .addAnnotatedClass(Student.class)
                                    .buildSessionFactory();
        Session session= factory.getCurrentSession();
        try
        {
            session.beginTransaction();
            int id=2;
            Student student = session.get(Student.class,id);
            Course course1=new Course("Rubik's cube");
            Course course2 = new Course("Atari Games");
            course1.addStudent(student);
            course2.addStudent(student);
            session.save(course1);
            session.save(course2);


            session.getTransaction().commit();

        }
        finally{
            session.close();
            factory.close();
        }
    }
}
