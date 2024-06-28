package com.claurier.habitat.souscription.infrastructure.persistence.repository;

import com.claurier.habitat.souscription.infrastructure.common.event.IdempotencyEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IdempotencyRepository extends CrudRepository<IdempotencyEntity, String>
{

}
