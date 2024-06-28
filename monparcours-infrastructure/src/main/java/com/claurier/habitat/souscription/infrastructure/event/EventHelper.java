package com.claurier.habitat.souscription.infrastructure.event;

import java.time.LocalDateTime;

import com.claurier.habitat.souscription.infrastructure.common.event.IdempotencyEntity;
import com.claurier.habitat.souscription.infrastructure.persistence.repository.IdempotencyRepository;
import org.springframework.stereotype.Component;

@Component
public class EventHelper
{

    private final IdempotencyRepository idempotencyRepository;

    public EventHelper(IdempotencyRepository idempotencyRepository) {
        this.idempotencyRepository = idempotencyRepository;
    }

    public void saveIdempotencyIdToEnsureCurrentMessageWontNeverBeProcessedAgain(String idempotencyId)
    {
        var idempotencyEntity = new IdempotencyEntity();
        idempotencyEntity.id = idempotencyId;
        idempotencyEntity.at = LocalDateTime.now();
        idempotencyRepository.save(idempotencyEntity);
    }

    public boolean isEventAlreadyProcessed(String idempotencyId)
    {
        return idempotencyRepository.findById(idempotencyId).isPresent();
    }

}
