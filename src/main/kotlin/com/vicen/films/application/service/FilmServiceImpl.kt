package com.vicen.films.application.service

import com.vicen.films.application.commands.CreateFilmCommand
import com.vicen.films.application.queries.GetFilmQuery
import com.vicen.films.application.queries.GetFilmsQuery
import com.vicen.films.application.repository.FilmRepository
import com.vicen.films.application.repository.StaffRepository
import com.vicen.films.domain.films.Film
import com.vicen.films.domain.films.FilmEntity
import com.vicen.films.domain.films.RoleVO
import java.util.*

class FilmServiceImpl(val filmRepository: FilmRepository, val staffRepository: StaffRepository) : FilmService {

    override fun getFilm(query: GetFilmQuery): Film = filmRepository.getFilm(query.filmId)

    override fun getFilms(query: GetFilmsQuery): List<Film> = filmRepository.films

    override fun createFilm(command: CreateFilmCommand): Film {
        val director = staffRepository.getStaffMember(command.directorId)
        val cast = command.cast.map { pair -> RoleVO(name = pair.first, actor = staffRepository.getStaffMember(pair.second)) }
        val film : Film = FilmEntity(
                command.title,
                command.year,
                command.genre,
                director,
                cast);
        return filmRepository.createFilm(film);
    }


}
