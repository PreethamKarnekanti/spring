package com.preetham.hibernate.demo;

import com.preetham.hibernate.demo.entity.Course;
import com.preetham.hibernate.demo.entity.Instructor;
import com.preetham.hibernate.demo.entity.InstructorDetail;
import com.preetham.hibernate.demo.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateCourseAndReviewsDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                                    .addAnnotatedClass(Instructor.class)
                                    .addAnnotatedClass(InstructorDetail.class)
                                    .addAnnotatedClass(Course.class)
                                    .addAnnotatedClass(Review.class)
                                    .buildSessionFactory();
        Session session= factory.getCurrentSession();
        try
        {
            session.beginTransaction();
            Course tempCourse=new Course("Pacman");
            tempCourse.addReview(new Review("Great Course"));
            tempCourse.addReview(new Review("good Course"));
            tempCourse.addReview(new Review("Waste Course"));
            session.save(tempCourse);
            session.getTransaction().commit();

        }
        finally{
            session.close();
            factory.close();
        }
    }
}
