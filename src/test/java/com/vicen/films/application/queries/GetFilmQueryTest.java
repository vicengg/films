package com.vicen.films.application.queries;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class GetFilmQueryTest {

    @Test
    @DisplayName("It instances the query from all its values.")
    void intanceCompleteQuery() {
        UUID uuid = UUID.randomUUID();
        GetFilmQuery query = new GetFilmQuery(uuid);
        assertEquals(uuid, query.getFilmId());
    }

    @Test
    @DisplayName("It instances the query from null values.")
    void instanceQueryFromNullValues() {
        GetFilmQuery query = new GetFilmQuery(null);
        assertNull(query.getFilmId());
    }

}
