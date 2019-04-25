package com.mirkelor.springdemo;

public class TennisCoach implements Coach{
    private FortuneService fortuneService;

    public TennisCoach() {
    }

    public TennisCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Do stroke practice 20 min";
    }

    @Override
    public String getDailyFortune() {
        return getFortuneService().getFortune();
    }

    public FortuneService getFortuneService() {
        return fortuneService;
    }

    public void setFortuneService(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    public void initMethod(){
        System.out.println("TennisCoach: inside method initMethod");
    }

    public void cleanMethod(){
        System.out.println("TennisCoach: inside method cleanMethod");
    }
}
