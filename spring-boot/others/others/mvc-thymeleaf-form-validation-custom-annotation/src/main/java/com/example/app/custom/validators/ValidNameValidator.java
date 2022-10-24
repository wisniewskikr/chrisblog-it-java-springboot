package com.example.app.custom.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.example.app.custom.annotations.ValidName;

public class ValidNameValidator implements ConstraintValidator<ValidName, String> {
	
	 private String validName;
	 
	 @Override
	 public void initialize(ValidName validName) {
		 this.validName = validName.name();
	 }

	 @Override
	 public boolean isValid(String name, ConstraintValidatorContext context) {
	 
		 if (name == null || "".equals(name))
			 return false;
	 
		 if (name.equals(validName)) 
			 return true;
		 		 
		 return false;
		 
	 }

}
