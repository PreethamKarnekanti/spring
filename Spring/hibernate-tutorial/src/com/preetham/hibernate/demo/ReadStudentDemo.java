package com.preetham.hibernate.demo;

import com.preetham.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class ReadStudentDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
        Session session= factory.getCurrentSession();
        try
        {
            Student tempStudent = new Student("Preetham","k","pqr@gmail.com");
            session.beginTransaction();
            System.out.println(tempStudent);
            session.save(tempStudent);
            session.getTransaction().commit();
            System.out.println("object saved");
            System.out.println();
            //findout the student's id
            System.out.println("getting the student id "+tempStudent.getId());
            System.out.println();
            session=factory.getCurrentSession();
            session.beginTransaction();
            System.out.println("getting the student with id "+tempStudent.getId());
            System.out.println();
            Student myStudent= session.get(Student.class,1);
            System.out.println("get complete: "+myStudent);
            session.getTransaction().commit();
            System.out.println("Done!");
        }
        finally{
            factory.close();
        }
    }
}
