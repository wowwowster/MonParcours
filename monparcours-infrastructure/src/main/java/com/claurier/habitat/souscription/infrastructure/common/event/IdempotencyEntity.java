package com.claurier.habitat.souscription.infrastructure.common.event;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

import jakarta.persistence.Table;

@Entity
@Table(name = "TB_IDEMPOTENCY")
public class IdempotencyEntity {

    @Id
    public String id;

    @Column(
            name = "at",
            columnDefinition = "DATE")
    public LocalDateTime at;

}
