package com.epam.lab.spring.khokhliatskii.evernote.aop;

import lombok.extern.log4j.Log4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Log4j
public class LoggingAspect {

    @Pointcut("@annotation(LogPerformance)")
    void serviceMethod() {
    }

    @Around("serviceMethod()")
    public Object logPerformanceWebServices(ProceedingJoinPoint joinPoint) throws Throwable {

        long start = System.nanoTime();

        Object result = joinPoint.proceed();

        long end = System.nanoTime();

        System.out.println(joinPoint.getSignature()+" is performed in " + (end - start) + " nanosec");
        log.info(joinPoint.getSignature()+" is performed in " + (end - start) + " nanosec");

        return result;
    }

}
