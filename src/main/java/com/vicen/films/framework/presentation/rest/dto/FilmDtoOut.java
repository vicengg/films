package com.vicen.films.framework.presentation.rest.dto;

import com.vicen.films.domain.Identifiable;
import com.vicen.films.domain.films.Film;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class FilmDtoOut extends FilmDtoIn {

    private String id;

    private FilmDtoOut(String id,
                       String title,
                       String year,
                       String genre,
                       String directorId,
                       List<RoleDto> cast) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.genre = genre;
        this.directorId = directorId;
        this.cast = cast;
    }

    public static FilmDtoOut of(Film film) {
        if (Objects.isNull(film)) {
            return null;
        }
        return new FilmDtoOut(
                Identifiable.Companion.getIdFrom(film).toString(),
                film.getTitle(),
                Optional.ofNullable(film.getYear()).map(Objects::toString).orElse(null),
                Optional.ofNullable(film.getGenre()).map(Objects::toString).orElse(null),
                Optional.ofNullable(film.getDirector()).map(director -> Identifiable.Companion.getIdFrom(director).toString()).orElse(null),
                Optional.ofNullable(film.getCast())
                        .map(cast -> cast.stream().map(RoleDto::of).collect(Collectors.toList()))
                        .orElse(Collections.emptyList()));
    }

    public String getId() {
        return id;
    }

}
