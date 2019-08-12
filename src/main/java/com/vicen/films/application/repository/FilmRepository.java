package com.vicen.films.application.repository;

import com.vicen.films.domain.films.Film;
import com.vicen.films.domain.people.StaffMember;

import java.util.List;
import java.util.UUID;

public interface FilmRepository {

    Film createFilm(Film film);

    List<Film> getFilms();

    Film getFilm(UUID filmId);
}
