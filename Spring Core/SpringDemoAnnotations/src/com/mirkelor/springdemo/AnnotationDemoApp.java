package com.mirkelor.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

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
        System.out.println(theCoach.getDailyWorkouts());

        System.out.println(theCoach.getFortuneService());

        System.out.println(((TennisCoach) theCoach).getEmail());
        System.out.println(((TennisCoach) theCoach).getTeam());
        System.out.println(((TennisCoach) theCoach).getName());

        System.out.println(result);
        System.out.println("Memory address of theCoach is " + theCoach);
        System.out.println("Memory address of alphaCoach is " + alphaCoach);
        // close the context
        context.close();

    }
}
