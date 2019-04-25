package com.mirkelor.hibernate.demo;

import com.mirkelor.hibernate.demo.entity.Course;
import com.mirkelor.hibernate.demo.entity.Instructor;
import com.mirkelor.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateInstructorDemo {

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

            // create the objects
            Instructor instructor =
                    new Instructor("Natalie", "Public", "natalie.public@gmail.com");

            InstructorDetail instructorDetail =
                    new InstructorDetail(
                            "http://www.youtube.com/natalie.public",
                            "Video Games"
                    );

            // associate the objects
            instructor.setInstructorDetail(instructorDetail);

            // start a transaction
            session.beginTransaction();

            // save the instructor
            //
            // Note: this will ALSO save the details object
            // because of CascadeType.ALL
            //
            System.out.println("Saving instructor: " + instructor);
            session.save(instructor);

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        }
        finally {

            // add clean up code
            session.close();

            factory.close();
        }

    }
}
