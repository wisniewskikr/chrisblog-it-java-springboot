package com.example.app.custom.ascepts;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
 
@Aspect
@Component
public class TraceableAspect {
 
    @Around("@annotation(com.example.app.annotations.Traceable)")
    public Object trace(ProceedingJoinPoint joinPoint) throws Throwable {        
         
        long start = System.currentTimeMillis();
 
        Object result = joinPoint.proceed();
        
        long stop = System.currentTimeMillis();
 
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        System.out.println(String.format("Method '%s' duration: %s miliseconds.", signature.getMethod().getName(), stop - start));
 
        return result;
    }
 
}
