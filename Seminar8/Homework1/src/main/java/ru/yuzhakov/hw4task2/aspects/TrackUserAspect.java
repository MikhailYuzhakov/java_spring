package ru.yuzhakov.hw4task2.aspects;

import lombok.extern.java.Log;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Log
public class TrackUserAspect {
    @Around("@annotation(ru.yuzhakov.hw4task2.aspects.TrackUserAction)")
    public Object trackUserActions(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();

        long executionTime = System.currentTimeMillis() - start;
        log.info(joinPoint.getSignature() + " executed in " + executionTime + "ms");
        return proceed;
    }
}
