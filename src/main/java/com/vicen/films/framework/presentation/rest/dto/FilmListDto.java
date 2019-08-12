package com.vicen.films.framework.presentation.rest.dto;

import com.vicen.films.domain.films.Film;

import java.util.List;
import java.util.stream.Collectors;

public class FilmListDto {

    private final List<FilmDtoOut> films;

    private FilmListDto(List<FilmDtoOut> films) {
        this.films = films;
    }

    public static FilmListDto of(List<Film> staff) {
        return new FilmListDto(staff.stream().map(FilmDtoOut::of).collect(Collectors.toList()));
    }

    public List<FilmDtoOut> getFilms() {
        return films;
    }
}
