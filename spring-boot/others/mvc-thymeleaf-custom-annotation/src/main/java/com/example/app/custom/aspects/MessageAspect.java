package com.example.app.custom.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import com.example.app.custom.annotations.Message;
import java.lang.reflect.Field;
import org.aspectj.lang.JoinPoint;
 
@Aspect
@Component
public class MessageAspect {
 
    @Before("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public void greeting(JoinPoint joinPoint) throws Throwable {  
    	
    	Object[] args = joinPoint.getArgs();
    	for (Object object : args) {
			
    		Field[] fields = object.getClass().getDeclaredFields();
    		for (int i = 0; i < fields.length; i++) {

				Message message = fields[i].getAnnotation(Message.class);
				if (message == null) {
					continue;
				}
				
				fields[i].setAccessible(true);								
				try {
					fields[i].set(object, message.value());
				} catch (IllegalArgumentException | IllegalAccessException e) {
					e.printStackTrace();
				}
				
			}
    		
		}         
       
    }
 
}
