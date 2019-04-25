package com.mirkelor.springdemo;

public class CricketCoach implements Coach{

    private FortuneService fortuneService;

    // add new fields for email address and team
    private String emailAddress;
    private String team;

    // create no-arg constructor
    public CricketCoach() {
        //System.out.println("CricketCoach: inside no-arg constructor");
    }

    public void setFortuneService(FortuneService fortuneService) {
        //System.out.println("CricketCoach: inside setter method - setFortuneService");
        this.fortuneService = fortuneService;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getTeam() {
        return team;
    }

    public void setEmailAddress(String emailAddress) {
        //System.out.println("CricketCoach: email address setter method");
        this.emailAddress = emailAddress;
    }

    public void setTeam(String team) {
        //System.out.println("CricketCoach: team setter method");

        this.team = team;
    }

    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
