package com.claurier.habitat.souscription.infrastructure.common.adapter;

import com.claurier.habitat.souscription.domain.common.model.UniqueId;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

public interface EntityMapperUtil
{

    default UniqueId uuidToUniqueId(UUID uuid)
    {
        return uuid != null ? new UniqueId(uuid.toString()) : null;
    }

    default UUID uniqueIdToUUID(UniqueId id)
    {
        return id != null ? UUID.fromString(id.getValue()) : null;
    }

    default String uniqueIdToString(UniqueId uid)
    {
        return uid != null ? uid.getValue() : null;
    }

    default UniqueId stringToUniqueId(String uid)
    {
        return uid != null ? new UniqueId(uid) : null;
    }

    default String optionalString(Optional<String> value)
    {
        return value.orElse(StringUtils.EMPTY);
    }

    default LocalDate optionalLocalDate(Optional<LocalDate> value)
    {
        return value.orElse(null);
    }

    default String mapToString(CharSequence value)
    {
        return value != null ? value.toString() : null;
    }

}
