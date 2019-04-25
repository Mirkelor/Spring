package com.mirkelor;

import com.mirkelor.dao.AccountDAO;
import com.mirkelor.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {

    public static void main(String[] args){

        // read spring config java class
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        // get the bean from spring container
        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);

        // get membership bean from spring container
        MembershipDAO membershipDAO =
                context.getBean("membershipDAO", MembershipDAO.class);

        // call the bussiness method
        Account account = new Account();
        accountDAO.addAccount(account, true);
        accountDAO.doWork();

        // call the accountdao getter/setter methods
        accountDAO.setName("foobar");
        accountDAO.setServiceCode("silver");

        String name = accountDAO.getName();
        String code = accountDAO.getServiceCode();

        // call the membership business method
        membershipDAO.addSillyAccount();
        membershipDAO.goToSleep();

        // close the context
        context.close();

    }
}
