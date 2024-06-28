package com.claurier.habitat.souscription.infrastructure.event.consumer;

import org.springframework.lang.Nullable;

public interface Consumer<T> {

    void consume(@Nullable T dto); //throws TechnicalHabitatException;

}
