package com.mirkelor.aspect;

import com.mirkelor.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

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
        for(Object tempArg : args){
            System.out.println(tempArg);

            if(tempArg instanceof Account){

                // downcast and print Account specific stuff
                Account account = (Account) tempArg;

                System.out.println("Account name: " + account.getName());
                System.out.println("Account level: " + account.getLevel());
            }
        }
    }



}
