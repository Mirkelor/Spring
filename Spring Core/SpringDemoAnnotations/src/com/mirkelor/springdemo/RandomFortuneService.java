package com.mirkelor.springdemo;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomFortuneService implements FortuneService{

    private String[] data = {
            "Mother of good luck",
            "Father of good luck",
            "Son of good luck",
            "Daughter of good luck"
    };

    private Random random = new Random();

    @Override
    public String getFortune() {
        int index = random.nextInt(data.length);
        String fortune = data[index];
        return fortune;
    }
}
