package com.mirkelor.springdemo;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

@Component
public class FileReadFortuneService implements FortuneService{

    private List<String> fortuneList = new ArrayList<>();

    private Random random = new Random();

    private FileReadFortuneService() {
    }

    @Override
    public String getFortune() {
        int index = random.nextInt(fortuneList.size());
        return fortuneList.get(index);
    }

    @PostConstruct
    private void FileRead() throws FileNotFoundException {
        System.out.println(">> FileReadFortuneService inside method: FileRead()");
        File file = new File("src/fortunes");
        Scanner fileScanner = new Scanner(file);

        while(fileScanner.hasNextLine()){
            fortuneList.add(fileScanner.nextLine());
        }
    }
}
