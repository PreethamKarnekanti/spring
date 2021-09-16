package com.preetham.hibernate.demo;

import com.preetham.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class UpdateStudentDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
        Session session= factory.getCurrentSession();
        try
        {
            int studentId=1;
            session.beginTransaction();
            Student myStudent = session.get(Student.class,studentId);
            myStudent.setLastName("Bolli");
            System.out.println(myStudent);
            session.getTransaction().commit();


            session = factory.getCurrentSession();
            session.beginTransaction();
            //update email of all students

            session.createQuery("update Student set email='foo@gmail.com'").executeUpdate();

            session.getTransaction().commit();

        }
        finally{
            factory.close();
        }
    }
}
