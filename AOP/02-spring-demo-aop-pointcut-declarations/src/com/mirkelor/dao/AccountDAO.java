package com.mirkelor.dao;

import com.mirkelor.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

    public void addAccount(Account account, boolean vipFlag){

        System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
    }

    public boolean doWork(){

        System.out.println(getClass() + ": doWork()");
        return false;
    }
}
