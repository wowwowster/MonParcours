package com.claurier.habitat.souscription.domain.validation.annotations;

import com.claurier.habitat.souscription.domain.validation.UuidValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.Documented;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UuidValidator.class)
@Documented
public @interface ValidUuid
{
    String message() default "L'identifiant unique n'est pas un UUID valide";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
