package com.mirkelor;

import com.mirkelor.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterThrowingApp {

    public static void main(String[] args){

        // read spring config java class
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        // get the bean from spring container
        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);

        // call method to find the accounts
        List<Account> accountList = null;

        try{
            // add a boolean flag to simulate exceptions
            boolean tripWire = true;
            accountList = accountDAO.findAccounts(tripWire);

        } catch (Exception e){
            System.out.println("\nMain Program ... caught exception: " + e);
        }

        // display the accounts
        System.out.println("\n\nMain Program: AfterThrowingApp");
        System.out.println("----");

        System.out.println(accountList);

        System.out.println("\n");

        // close the context
        context.close();

    }
}
