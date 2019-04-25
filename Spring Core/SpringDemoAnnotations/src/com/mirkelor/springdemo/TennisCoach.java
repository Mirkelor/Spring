package com.mirkelor.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


@Component
public class TennisCoach implements Coach{

    @Autowired
    @Qualifier("fileReadFortuneService")
    private FortuneService fortuneService;

    @Value("${p.email}")
    private String email;

    @Value("${p.team}")
    private String team;

    @Value("${a.email}")
    private String name;

    public String getEmail() {
        return email;
    }

    public String getTeam() {
        return team;
    }

    public String getName() {
        return name;
    }

    public TennisCoach() {
        System.out.println(">> TennisCoach: inside default constructor");
    }

    /*@Autowired
    public void setFortuneService(FortuneService fortuneService) {
        System.out.println(">> TennisCoach: inside setFortuneService() method");
        this.fortuneService = fortuneService;
    }*/

    /*@Autowired
    public TennisCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }*/

    @Override
    public String getDailyWorkouts() {
        return "Practice your backend volley";
    }

    @Override
    public String getFortuneService() {
        return fortuneService.getFortune();
    }

    @PostConstruct
    public void doMyStartupStuff(){
        System.out.println(">> TennisCoach: inside method doMyStartupStuff()");
    }

    @PreDestroy
    public void doMyCleanupStuff(){
        System.out.println(">> TennisCoach: inside method doMyCleanupStuff()");
    }

}
