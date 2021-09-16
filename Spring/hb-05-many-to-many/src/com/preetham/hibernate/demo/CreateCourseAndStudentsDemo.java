package com.preetham.hibernate.demo;

import com.preetham.hibernate.demo.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateCourseAndStudentsDemo {
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
            Course tempCourse=new Course("Pacman");
            Student student1=new Student("Preetham","k","pree@gmail.com");
            Student student2 =new Student("Ranadheer","B","rana@gmail.com");
            tempCourse.addStudent(student1);
            tempCourse.addStudent(student2);
            session.save(tempCourse);
            session.save(student1);
            session.save(student2);
            session.getTransaction().commit();

        }
        finally{
            session.close();
            factory.close();
        }
    }
}
