package com.demo.aspect;

import com.demo.annotation.Secured;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

@Aspect
@Component
public class CurrencyServiceAspect {

    @Pointcut("within(com.demo.service.*)")
    public void withinCurrencyServicePointCut(){

    }

    @Pointcut("@within(com.demo.annotation.Secured)")
    public void withinAnnotationCurrencyServicePointCut(){

    }
    @Pointcut("@target(com.demo.annotation.Secured)")
    public void targetAnnotationCurrencyServicePointCut(){

    }
    @Pointcut("@annotation(com.demo.annotation.InTransaction)")
    public void annotationCurrencyService(){}

    @Pointcut("bean(currency)")
    public void beanCurrencyServicePointCut(){

    }

    @Pointcut("@args(com.demo.annotation.Validation)")
    public void argsAnnotationCurrencyServicePointCut(){

    }

    //@After("targetAnnotationCurrencyServicePointCut()")
    public void argsAnnotationCurrencyAdvice(JoinPoint joinPoint){
        String classname = joinPoint.getTarget().getClass().getSimpleName();


        System.out.println(
                String.format("%s ' %s method is invoked with %s after advice in [%s].",classname
                        ,joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs())
                        , LocalDateTime.now())
        );
    }

   // @AfterReturning(value = "argsAnnotationCurrencyServicePointCut()", returning = "country")
    public void argsAnnotationReturningCurrencyAdvice(JoinPoint joinPoint,AfterReturning returning){
        String classname = joinPoint.getTarget().getClass().getSimpleName();


        System.out.println(
                String.format("%s ' %s method is invoked with %s parameter after returning ."+
                        "advice return value :: [%s} in [%s].",classname
                        ,joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs())
                       // ,country
                        , LocalDateTime.now())
        );
    }

    //@AfterThrowing(value = "argsAnnotationCurrencyServicePointCut()", throwing = "e")
    public void argsAnnotationThrowingCurrencyAdvice(JoinPoint joinPoint,Throwable e){
        String classname = joinPoint.getTarget().getClass().getSimpleName();


        System.out.println(
                String.format("%s ' %s method is invoked with %s parameter after throwing ."+
                                "advice exception class is :: [%s} in [%s].",classname
                        ,joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs())
                        ,e.getClass().getSimpleName()
                        , LocalDateTime.now())
        );
    }

    //@Before("beanCurrencyServicePointCut()")
    public void beforeBeanCurrencyAdvice(JoinPoint joinPoint){
        String classname = joinPoint.getTarget().getClass().getSimpleName();


        System.out.println(
                String.format("%s ' %s method is invoked with %s before advice in [%s].",classname
                        ,joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs())
                        , LocalDateTime.now())
        );
    }

   //@Before("withinCurrencyServicePointCut()")
    public void beforeCurrencyAdvice(JoinPoint joinPoint){
        String classname = joinPoint.getTarget().getClass().getSimpleName();


        System.out.println(
                String.format("%s ' %s method is invoked with %s before advice in [%s].",classname
                        ,joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs())
                        , LocalDateTime.now())
        );
    }

    @Pointcut("args(int,int)")
    public void argCurrencyAspect(){

    }

   // @Before("argCurrencyAspect()")
    public void argsCurrencyAdvice(JoinPoint joinPoint){
        String classname = joinPoint.getTarget().getClass().getSimpleName();


        System.out.println(
                String.format("%s ' %s method is invoked with %s before advice in [%s].",classname
                        ,joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs())
                        , LocalDateTime.now())
        );
    }

    //@Before("annotationCurrencyService()")
    public void beforeWithinAnnotationCurrencyAdvice(JoinPoint joinPoint){
        String classname = joinPoint.getTarget().getClass().getSimpleName();


        System.out.println(
                String.format("%s ' %s method is invoked with %s before advice in [%s].",classname
                        ,joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs())
                        , LocalDateTime.now())
        );
    }

    @Around("targetAnnotationCurrencyServicePointCut()")
    public Object beforeWithinAnnotationCurrencyAroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        String classname = joinPoint.getTarget().getClass().getSimpleName();


        System.out.println(
                String.format("%s ' %s method is invoked with %s before advice in [%s].",classname
                        ,joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs())
                        , LocalDateTime.now())
        );

        try{
            return joinPoint.proceed();
        }catch (Exception e){
           System.out.println("Exception has been caught.");

        }
        finally {
            System.out.println("After Invoking method......");
        }
        return null;
    }
}
