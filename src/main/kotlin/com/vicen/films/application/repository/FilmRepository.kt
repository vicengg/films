package com.vicen.films.application.repository

import com.vicen.films.domain.films.Film
import java.util.UUID

interface FilmRepository {

    val films: List<Film>

    fun createFilm(film: Film): Film

    fun getFilm(filmId: UUID): Film
}
