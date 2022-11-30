package com.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

@Component
//@Aspect
public class MyAccountServiceAspect {

    @Pointcut("target(com.demo.service.MyAccountService)")
    public void thisMyAccountServicePointCut(){}

   // @Before("thisMyAccountServicePointCut()")
    public void beforeMyAccountServiceAdvice(JoinPoint joinPoint){
        String classname = joinPoint.getTarget().getClass().getSimpleName();


        System.out.println(
                String.format("%s ' %s method is invoked with %s before advice in [%s].",classname
                        ,joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs())
                        , LocalDateTime.now())
        );
    }
}
