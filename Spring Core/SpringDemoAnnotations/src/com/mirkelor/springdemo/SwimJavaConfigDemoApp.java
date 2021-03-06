package com.mirkelor.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigDemoApp {

    public static void main(String[] args){

        // read the spring config file
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(SportConfig.class);

        // get the bean from string container
        Coach theCoach = context.getBean("swimCoach", Coach.class);

        Coach alphaCoach = context.getBean("swimCoach", Coach.class);

        Boolean result;

        result = (theCoach == alphaCoach);

        // call a method on the bean
        System.out.println(theCoach.getDailyWorkouts());

        System.out.println(theCoach.getFortuneService());

        System.out.println("email: " + ((SwimCoach) theCoach).getEmail());
        System.out.println("team: " + ((SwimCoach) theCoach).getTeam());
        System.out.println("name: " + ((SwimCoach) theCoach).getName());

        System.out.println(result);
        System.out.println("Memory address of theCoach is " + theCoach);
        System.out.println("Memory address of alphaCoach is " + alphaCoach);
        // close the context
        context.close();

    }
}
