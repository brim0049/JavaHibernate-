package com.newthinktank.JEETut3;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.jvnet.staxex.StAxSOAPBody.Payload;

import jakarta.validation.*;

@Constraint(validatedBy = NumSerieValidator.class)
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface NumSerieValide {

	    String message() default "numero de serie invalide";

	    Class<?>[] groups() default {};

	    Class<? extends Payload>[] payload() default {};

	    

}