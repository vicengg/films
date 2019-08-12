package com.vicen.films.application.queries;

import java.util.UUID;

public class GetFilmQuery implements Query {

    private final UUID filmId;

    public GetFilmQuery(UUID filmId) {
        this.filmId = filmId;
    }

    public UUID getFilmId() {
        return filmId;
    }
}
