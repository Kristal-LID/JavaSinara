package com.urfu.homework.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class AspectLimit {

    @Autowired
    private AspectConfig aspectConfig;

    @Autowired
    private RequestCounter requestCounter;

    @Pointcut("execution(* com.urfu.homework.aspect.AspectControl.*(..)))")
    public void apiMethods() {}

    @Around("apiMethods()")
    public Object checkLimit(ProceedingJoinPoint joinPoint) throws Throwable {

        String methodName = joinPoint.getSignature().toShortString();
        int currentCount = requestCounter.getCount(methodName);
        requestCounter.increment(methodName);

        if (currentCount >= aspectConfig.getMaxRequests()) {
            log.info ("Лимит для метода: ", methodName);
            return null;
        }

        return joinPoint.proceed();
    }
}