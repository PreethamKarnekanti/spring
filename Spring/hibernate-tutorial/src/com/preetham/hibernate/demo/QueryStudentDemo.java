package com.preetham.hibernate.demo;

import com.preetham.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class QueryStudentDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
        Session session= factory.getCurrentSession();
        try
        {

            session.beginTransaction();
            System.out.println("------------All Students-------------------");
            List<Student> studentList = session.createQuery("from Student").list();
            printStudents(studentList);
            System.out.println();
            System.out.println();

            System.out.println("-------------students with last name is k---------------");
            studentList=session.createQuery("from Student s where s.lastName='k'").list();
            printStudents(studentList);
            System.out.println();
            System.out.println();


            System.out.println("   ----------------------query the students whose lastname is 'b' or first name 'ranadheer' ------------------");
            studentList= session.createQuery("from Student s where s.lastName='b' or s.firstName='ranadheer'").list();
            printStudents(studentList);
            System.out.println();
            System.out.println();

            System.out.println("----email id like gmail.com--------");
            studentList=session.createQuery("from Student s where email like '%gmail.com'").list();
            printStudents(studentList);
            session.getTransaction().commit();

        }
        finally{
            factory.close();
        }
    }

    private static void printStudents(List<Student> studentList) {
        for(Student tempStudent : studentList)
            System.out.println(tempStudent);
    }
}
