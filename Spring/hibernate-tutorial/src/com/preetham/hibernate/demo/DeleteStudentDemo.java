package com.preetham.hibernate.demo;

import com.preetham.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class DeleteStudentDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
        Session session= factory.getCurrentSession();
        try
        {
            int studentId=1;
            session.beginTransaction();
           // Student myStudent = session.get(Student.class,studentId);
            //session.delete(myStudent);
            session.getTransaction().commit();


            session = factory.getCurrentSession();
            session.beginTransaction();
            //update email of all students

            session.createQuery("delete from Student s where id=4").executeUpdate();

            session.getTransaction().commit();

        }
        finally{
            factory.close();
        }
    }
}
