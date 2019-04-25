package com.mirkelor.springdemo;

import org.springframework.beans.factory.annotation.Value;

public class SwimCoach implements Coach{

    private FortuneService fortuneService;

    @Value("${p.email}")
    private String email;

    @Value("${p.team}")
    private String team;

    @Value("${a.name}")
    private String name;

    public SwimCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkouts() {
        return "Swim 1000 meters as a warm up";
    }

    @Override
    public String getFortuneService() {
        return fortuneService.getFortune();
    }

    public String getEmail() {
        return email;
    }

    public String getTeam() {
        return team;
    }

    public String getName() {
        return name;
    }
}
