package com.example.app.aspects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
import org.springframework.web.context.request.RequestContextHolder;
 
@Aspect
@Component
public class LoggingAspect {
	
    private static final Logger LOGGER = LogManager.getLogger(LoggingAspect.class);
     
    @Around("execution(* com.example.app..*(..)))")
    public Object profileAllMethods(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
    	
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
          
        //Get intercepted method details
        String className = methodSignature.getDeclaringType().getSimpleName();
        String methodName = methodSignature.getName();
          
        final StopWatch stopWatch = new StopWatch();
          
        //Measure method execution time
        stopWatch.start();
        Object result = proceedingJoinPoint.proceed();
        stopWatch.stop();
        
        String sessionId = RequestContextHolder.currentRequestAttributes().getSessionId();
  
        //Log method execution time
        LOGGER.info("Execution time of " + className + "." + methodName + " sessionId: " + sessionId);
  
        return result;
    }
}
