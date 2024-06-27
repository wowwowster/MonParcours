package com.claurier.habitat.souscription.domain.common.model;

import com.claurier.habitat.souscription.domain.common.ddd.BaseValueObject;

import com.claurier.habitat.souscription.domain.validation.annotations.ValidUuid;
import jakarta.validation.Payload;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@BaseValueObject.DDD.ValueObjectId
public class UniqueId extends BaseValueObject<UniqueId>
{
    @Constraint
    @ValidUuid
    private String value;

    public UniqueId(UniqueId other) {
        super(UniqueId.class);
        this.value = Objects.requireNonNull(other).getValue();
    }

    public UniqueId(String other) {
        super(UniqueId.class);
        this.value = Objects.requireNonNull(other);
    }

    public UniqueId() {
        super(UniqueId.class);
        this.value = UUID.randomUUID().toString();
    }

    public String getValue()
    {
        return value;
    }

    @Override
    protected List<Object> attributesToIncludeInEqualityCheck()
    {
        return Collections.singletonList(value);
    }

    @Documented
    @Target(
            {
                    ElementType.FIELD,
                    ElementType.PARAMETER
            })
    @Retention(RetentionPolicy.RUNTIME)
    @NotEmpty
    @Size(max = 36)
    @jakarta.validation.Constraint(validatedBy = {})
    public @interface Constraint
    {
        String message() default "Unique id should not be empty or over 36 chars";
        Class<?>[] groups() default {};
        Class<? extends Payload>[] payload() default {};

    }

}
