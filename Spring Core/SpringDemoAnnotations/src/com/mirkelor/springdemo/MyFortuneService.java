package com.mirkelor.springdemo;

public class MyFortuneService implements FortuneService{

    @Override
    public String getFortune() {
        return "Today is my day";
    }
}
