package com.example.app.custom.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.example.app.custom.validators.ValidNameValidator;
 
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.TYPE_USE })
@Constraint(validatedBy = ValidNameValidator.class)
public @interface ValidName {

	String name() default "";
	
	String message() default "Invalid name";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
	
}
