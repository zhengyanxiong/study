package com.Bernie;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;

/**
 * @author Bernie
 * @Date 2019/1/18 16:05
 **/
/*@Aspect
@Component*/
public class Aop {

    @Autowired
    private TransactionUtil transactionUtil;


    private TransactionStatus status;

    //@Before("execution(* com.Bernie.service.UserService.add(..))")
    public void begin() {
        System.out.println("前置通知");
    }

    //@After("execution(* com.Bernie.service.UserService.add(..))")
    public void after() {
        System.out.println("后置通知");
    }

    //@AfterReturning("execution(* com.Bernie.service.UserService.add(..))")
    public void afterReturning() {
        System.out.println("运行通知");
    }

    //@AfterThrowing("execution(* com.Bernie.service.UserService.add(..))")
    public void afterThrowing() {
        System.out.println("异常通知");
        transactionUtil.rollback(status);
    }

    //@Around("execution(* com.Bernie.service.UserService.add(..))")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("我是环绕通知-前");
        status = transactionUtil.begin();
        proceedingJoinPoint.proceed();
        System.out.println("我是环绕通知-后");
        transactionUtil.commit(status);
    }

}
