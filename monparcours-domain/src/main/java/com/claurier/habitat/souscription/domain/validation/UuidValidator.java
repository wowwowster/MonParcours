package com.claurier.habitat.souscription.domain.validation;

import com.claurier.habitat.souscription.domain.validation.annotations.ValidUuid;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.UUID;

/**
 * Validateur des champs UUID
 */
public class UuidValidator implements ConstraintValidator<ValidUuid, String>
{
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context)
    {
        if (value != null)
        {
            try
            {
                UUID.fromString(value);
                return true;
            }
            catch (IllegalArgumentException exception)
            {
                // Si on a une exception, alors "value" n'était pas un UUID valide.
            }
        }
        return false;
    }

}

