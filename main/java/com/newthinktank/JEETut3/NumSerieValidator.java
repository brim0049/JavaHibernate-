package com.newthinktank.JEETut3;
import jakarta.validation.*;

public class NumSerieValidator implements ConstraintValidator<NumSerieValide, Object> {
	  
	    private NumSerieValide numSerieValide;

	    @Override
	    public void initialize(NumSerieValide constraintAnnotation) {
	        this.numSerieValide = constraintAnnotation;
	    }

	    @Override
	    public boolean isValid(Object value, ConstraintValidatorContext context) {
	        if (value == null) {
	            return false;
	        }
	        String regex = "SN-[a-z]{3}-[0-9]{6}" ;
	        String data = String.valueOf(value);
	        return data.matches(regex);
	    }

	

}