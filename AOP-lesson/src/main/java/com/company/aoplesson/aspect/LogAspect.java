package com.company.aoplesson.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Aspect
@Configuration
@Slf4j
public class LogAspect {
    @Before("methodsOfUserController() && args(x)")
    public void log(int x) {
        log.info("method invoked: " + x);
    }

    @Before("allMethodsOfController()")
    public void logBefore(JoinPoint joinPoint) {
        log.info("methode invoked");
        log.info("signature {}", joinPoint.getSignature());
        Object[] args = joinPoint.getArgs();
        log.info("args: {}", List.of(args));
    }

    @After("allMethodsOfController()")
    public void logAfter(JoinPoint joinPoint) {
        log.info("methode finished");
    }

    @AfterReturning(value = "allMethodsOfController()", returning = "result")
    public void logAfter(JoinPoint joinPoint, Object result) {
        log.info("return: {}", result);
        log.info("methode finished");
    }

    @AfterThrowing(value = "methodsOfUserController()", throwing = "result")
    public void logAfter(JoinPoint joinPoint, Exception result) {
        log.info("exception message: {}", result.getMessage());
        log.info("methode finished");
    }

    @Around("allMethodsOfController()")
    public Object logAround(ProceedingJoinPoint proceedingJoinPoint) {
        try {
            log.info("method parameters: {}", proceedingJoinPoint.getArgs());

            Object response = proceedingJoinPoint.proceed();

            log.info("methode response: {}", response);

            return response;

        } catch (Throwable exception) {
            log.info("Exception message: {}", exception.getMessage());
            return exception;
        }

    }

    @Pointcut("within(com.company.aoplesson.*..*)")
    public void allMethodsOfController() {
    }

    @Pointcut("execution(* com.company.aoplesson.controller.UserController.*())")
    public void methodsOfUserController() {
    }
}
