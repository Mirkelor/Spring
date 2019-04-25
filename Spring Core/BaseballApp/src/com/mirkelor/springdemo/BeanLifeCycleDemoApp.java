package com.mirkelor.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeCycleDemoApp {

    public static void main(String[] args){

        // load the spring configuration file
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("beanLifeCycle-applicationContext.xml");

        // retrieve bean from string container
        Coach theCoach = context.getBean("myCoach", TrackCoach.class);

        // call methods on the bean
        System.out.println(theCoach.getDailyFortune());

        // close context
        context.close();
    }
}
