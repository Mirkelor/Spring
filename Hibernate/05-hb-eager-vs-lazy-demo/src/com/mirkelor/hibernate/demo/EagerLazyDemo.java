package com.mirkelor.hibernate.demo;

import com.mirkelor.hibernate.demo.entity.Course;
import com.mirkelor.hibernate.demo.entity.Instructor;
import com.mirkelor.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EagerLazyDemo {

    public static void main(String[] args){

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try{
            // start a transaction
            session.beginTransaction();

            // get the instructor from db
            int id = 1;
            Instructor tempInstructor = session.get(Instructor.class, id);

            System.out.println("mirkelor: Instructor" + tempInstructor);

            System.out.println("mirkelor: Courses" + tempInstructor.getCourses());

            // commit transaction
            session.getTransaction().commit();

            // close the session
            session.close();

            System.out.println("\nmirkelor: The session is now closed!\n");

            // option 1: call getter method while session is open

            // since courses are lazy loaded ... this should fail

            // get courses for the instructor
            System.out.println("mirkelor: Courses" + tempInstructor.getCourses());

            System.out.println("mirkelor: Done!");
        }
        finally {

            // add clean up code
            session.close();

            factory.close();
        }

    }
}
