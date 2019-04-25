package com.mirkelor.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {

    public static void main(String[] args){

        // read the spring config file
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        // get the bean from string container
        Coach theCoach = context.getBean("tennisCoach", Coach.class);

        Coach alphaCoach = context.getBean("tennisCoach", Coach.class);

        Boolean result;

        result = (theCoach == alphaCoach);

        // call a method on the bean
        System.out.println("\nIs that same object: " + result);
        System.out.println("\nMemory address of theCoach is " + theCoach);
        System.out.println("\nMemory address of alphaCoach is " + alphaCoach + "\n");
        // close the context
        context.close();

    }
}
