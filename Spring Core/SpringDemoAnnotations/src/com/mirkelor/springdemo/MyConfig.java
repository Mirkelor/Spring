package com.mirkelor.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {

    @Bean
    public FortuneService myFortuneService(){
        return new MyFortuneService();
    }

    @Bean
    public Coach karateCoach(){
        return new KarateCoach(myFortuneService());
    }
}
