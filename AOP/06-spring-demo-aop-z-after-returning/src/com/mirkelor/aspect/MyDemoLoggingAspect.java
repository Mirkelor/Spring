package com.mirkelor.aspect;

import com.mirkelor.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    // add a new advice for @AfterReturning on the findAccounts method

    @AfterReturning(
            pointcut = "execution(* com.mirkelor.dao.AccountDAO.findAccounts(..))",
            returning = "result")
    public void  afterReturningFindAccountsAdvice(
            JoinPoint joinPoint, List<Account> result){

        // print out which method we are advising on
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n=====>>> Executing @Af terReturning on method: " + method);

        // print out the results of the method call
        System.out.println("\n====>>> result is: " + result);
        
        // let's post-process the data ... let's modify it
        
        // convert the account names to uppercase
        convertAccountNamesToUpperCase(result);
        System.out.println("\n====>>> result is: " + result);
    }

    private void convertAccountNamesToUpperCase(List<Account> result) {

        // loop through accounts
        for(Account account : result){

            // get uppercase version of name
            String upperName = account.getName().toUpperCase();

            // update the name on the account
            account.setName(upperName);
        }
    }

    @Before("com.mirkelor.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint){
        System.out.println("\n=====>>> Executing @Before advice on method");

        // display the method signature
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

        System.out.println("Method: " + methodSignature);

        // display method arguments

        // get args
        Object[] args = joinPoint.getArgs();

        // loop thru args
        for(Object object : args){
            System.out.println(object);

            if(object instanceof Account){

                // downcast and print Account specific stuff
                Account account = (Account) object;

                System.out.println("Account name: " + account.getName());
                System.out.println("Account level: " + account.getLevel());
            }
        }


    }



}