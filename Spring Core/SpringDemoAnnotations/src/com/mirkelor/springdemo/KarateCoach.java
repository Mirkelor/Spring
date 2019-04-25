package com.mirkelor.springdemo;

public class KarateCoach implements Coach{

    private FortuneService fortuneService;

    public KarateCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkouts() {
        return "Do kick training for 30 minutes";
    }

    @Override
    public String getFortuneService() {
        return fortuneService.getFortune();
    }
}
