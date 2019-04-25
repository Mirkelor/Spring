package com.mirkelor.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyConfigDemoApp {

    public static void main(String[] args){

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig.class);

        KarateCoach theCoach = context.getBean("karateCoach", KarateCoach.class);

        System.out.println(theCoach.getDailyWorkouts());
        System.out.println(theCoach.getFortuneService());
    }
}
