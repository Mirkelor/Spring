package com.mirkelor;

import com.mirkelor.dao.AccountDAO;
import com.mirkelor.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterReturningApp {

    public static void main(String[] args){

        // read spring config java class
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        // get the bean from spring container
        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);

        // call method to find the accounts
        List<Account> accountList = accountDAO.findAccounts();

        // display the accounts
        System.out.println("\n\nMain Program: AfterReturningApp");
        System.out.println("----");

        System.out.println(accountList);

        System.out.println("\n");

        // close the context
        context.close();

    }
}
