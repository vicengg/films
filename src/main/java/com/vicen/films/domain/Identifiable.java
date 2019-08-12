package com.vicen.films.domain;

import java.util.UUID;

public interface Identifiable {

    UUID getId();

    static <T> UUID getIdFrom(T object) {
        if (object instanceof Identifiable) {
            return ((Identifiable) object).getId();
        } else {
            throw new NotIdentifiableException();
        }
    }

    class NotIdentifiableException extends RuntimeException {
        private NotIdentifiableException() {
            super("Not identifiable object.");
        }
    }

}
