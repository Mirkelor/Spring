package com.mirkelor.hibernate.demo;

import com.mirkelor.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryStudentDemo {

    public static void main(String[] args){

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try{
            // start a transaction
            session.beginTransaction();

            // query students
            List<Student> students = session.createQuery("from Student s where s.firstName='daffy'").getResultList();

            // display the students
            displayStudents(students);

            // query students : lastName='Public'
            students = session.createQuery("from Student s where s.lastName='Public'").getResultList();

            System.out.println("\nThe sutdents who have last name: Public");
            displayStudents(students);

            // query students : lastName='Public' or firstName='Duffy'
            students = session.createQuery("from Student s where lastName='Public' OR firstName='Daffy'").getResultList();

            System.out.println("\n\nStudents who have lastName='Public' or firstName='Duffy'");
            displayStudents(students);

            // query students where email LIKE 'gmail.com'
            students = session.createQuery("from Student where email LIKE '%gmail.com'").getResultList();

            System.out.println("\n\nStudents who have email LIKE 'gmail.com'");
            displayStudents(students);

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        }
        finally {
            factory.close();
        }

    }

    private static void displayStudents(List<Student> students) {
        for(Student student : students){
            System.out.println(student);
        }
    }
}
