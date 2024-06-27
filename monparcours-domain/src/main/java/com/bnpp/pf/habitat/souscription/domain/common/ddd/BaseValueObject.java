package com.claurier.habitat.souscription.domain.common.ddd;

import java.util.List;

import static java.lang.String.format;
import static java.util.Objects.hash;

public abstract class BaseValueObject<T extends BaseValueObject<T>>
{
    private final Class<T> type;

    protected BaseValueObject(Class<T> type)
    {
        this.type = type;
    }

    @Override
    public int hashCode()
    {
        return hash(attributesToIncludeInEqualityCheck());
    }

    @Override
    public boolean equals(Object obj)
    {
        if (!type.isInstance(obj))
        {
            return false;
        }
        var other = type.cast(obj);
        return this.attributesToIncludeInEqualityCheck().equals(other.attributesToIncludeInEqualityCheck());
    }

    @Override
    public String toString()
    {
        return format("[name - value] : [%s : %s]", type.getSimpleName(), attributesToIncludeInEqualityCheck());
    }

    protected abstract List<Object> attributesToIncludeInEqualityCheck();

}
