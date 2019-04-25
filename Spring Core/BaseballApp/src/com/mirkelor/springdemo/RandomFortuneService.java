package com.mirkelor.springdemo;

import java.util.ArrayList;

public class RandomFortuneService implements FortuneService{

    private ArrayList<String> randomFortune;

    public RandomFortuneService() {
        randomFortune = new ArrayList<>();
        randomFortune.add("Your luck is larger than lucky clover");
        randomFortune.add("God blessed you now you have holy luck");
        randomFortune.add("Someone wished you good luck and your luck boosted up");
    }

    @Override
    public String getFortune() {
        return randomFortune.get(randomNumberGenerator(3));
    }

    private int randomNumberGenerator(int i){
        double randomNumber = Math.random() * i;
        return (int) randomNumber;
    }
}
