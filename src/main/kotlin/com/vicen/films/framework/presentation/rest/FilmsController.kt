package com.vicen.films.framework.presentation.rest

import com.vicen.films.application.commands.CreateFilmCommand
import com.vicen.films.application.queries.GetFilmQuery
import com.vicen.films.application.service.FilmService
import com.vicen.films.domain.IdentifiableEnum
import com.vicen.films.domain.films.Genre
import com.vicen.films.framework.presentation.rest.dto.FilmDtoIn
import com.vicen.films.framework.presentation.rest.dto.FilmDtoOut
import com.vicen.films.framework.presentation.rest.dto.FilmListDto
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import java.time.Year
import java.util.*

@RestController
@RequestMapping("/film")
class FilmsController(val filmService: FilmService) : BaseController() {

    @RequestMapping(method = [RequestMethod.GET], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getFilms(): FilmListDto {
        return FilmListDto.of(filmService.getFilms())
    }

    @RequestMapping(value = ["/{uuid}"], method = [RequestMethod.GET], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getFilm(@PathVariable("uuid") uuid: String): FilmDtoOut {
        return FilmDtoOut.of(filmService.getFilm(GetFilmQuery(UUID.fromString(uuid))))
    }

    @RequestMapping(method = [RequestMethod.POST], consumes = [MediaType.APPLICATION_JSON_VALUE], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun createFilm(@RequestBody request: FilmDtoIn): FilmDtoOut {
        val command = CreateFilmCommand(
                title = request.title,
                year = Year.parse(request.year),
                genre = IdentifiableEnum.of<Genre>(request.genre),
                directorId = UUID.fromString(request.directorId),
                cast = request.cast.map { roleDto -> Pair(first = roleDto.roleName, second = UUID.fromString(roleDto.actorId)) })
        return FilmDtoOut.of(filmService.createFilm(command))
    }

}