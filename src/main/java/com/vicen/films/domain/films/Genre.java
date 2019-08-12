package com.vicen.films.domain.films;

import com.vicen.films.framework.errors.ErrorUtils;
import com.vicen.films.framework.errors.NotFoundError;

import java.util.Arrays;
import java.util.Objects;

public enum Genre {
    ADVENTURE("adventure"),
    COMEDY("comedy"),
    DRAMA("drama"),
    HORROR("horror"),
    MUSICAL("musical"),
    SCI_FI("sci-fi"),
    WAR("war"),
    WESTERN("western"),
    THRILLER("thriller");

    private final String genreId;

    Genre(String genreId) {
        this.genreId = genreId;
    }

    public static Genre of(String genreId) {
        return Arrays.stream(Genre.values())
                .filter(value -> value.getGenreId().equals(genreId))
                .findFirst()
                .orElseThrow(GenreNotFoundException::new);
    }

    public String getGenreId() {
        return genreId;
    }

    @Override
    public String toString() {
        return genreId;
    }

    public static class GenreNotFoundException extends RuntimeException {
        private GenreNotFoundException() {
            super("Genre ID doesn't exist.");
        }
    }

}
