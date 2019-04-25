package com.mirkelor.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PracticeBeanScopeApp {

    public static void main(String[] args){

        // load the spring configuration file
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("practiceBeanScope-applicationContext.xml");

        // retrieve bean from spring container
        Coach theCoach = context.getBean("myCoach", TennisCoach.class);
        Coach anotherCoach = context.getBean("myCoach", TennisCoach.class);

        boolean result = (theCoach == anotherCoach);

        // call methods from bean
        System.out.println(theCoach.getDailyWorkout());
        System.out.println(theCoach.getDailyFortune());

        System.out.println("\nCoaches are same: " + result);
        System.out.println("\nMemory for theCoach: " + theCoach);
        System.out.println("\nMemory for anotherCoach: " + anotherCoach);

        // close
        context.close();

    }
}
