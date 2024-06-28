package com.claurier.habitat.souscription.infrastructure.event.consumer;

import java.util.Objects;

// claurier : classe Key bidon
public class Key {

    private String id;

    public Key() {
    }

    public Key(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Key key = (Key) o;
        return Objects.equals(id, key.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Key{" + "id='" + id + '\'' + '}';
    }

}

