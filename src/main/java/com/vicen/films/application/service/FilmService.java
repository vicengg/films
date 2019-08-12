package com.vicen.films.application.service;

import com.vicen.films.application.commands.CreateFilmCommand;
import com.vicen.films.application.queries.GetFilmsQuery;
import com.vicen.films.domain.films.Film;

import java.util.List;

public interface FilmService {

    Film createFilm(CreateFilmCommand command);

    List<Film> getFilms(GetFilmsQuery query);
}
