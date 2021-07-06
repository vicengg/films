package com.vicen.films.application.service

import com.vicen.films.application.commands.CreateFilmCommand
import com.vicen.films.application.queries.GetFilmQuery
import com.vicen.films.application.queries.GetFilmsQuery
import com.vicen.films.domain.films.Film

interface FilmService {

    fun getFilms(query: GetFilmsQuery = GetFilmsQuery()): List<Film>
    fun getFilm(query: GetFilmQuery): Film
    fun createFilm(command: CreateFilmCommand): Film

}