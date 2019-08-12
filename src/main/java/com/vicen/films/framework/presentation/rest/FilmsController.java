package com.vicen.films.framework.presentation.rest;

import com.vicen.films.application.commands.CreateFilmCommand;
import com.vicen.films.application.queries.GetFilmQuery;
import com.vicen.films.application.queries.GetFilmsQuery;
import com.vicen.films.application.queries.GetStaffMemberQuery;
import com.vicen.films.application.service.FilmService;
import com.vicen.films.domain.films.Genre;
import com.vicen.films.framework.presentation.rest.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.Year;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/film")
public class FilmsController extends BaseController {

    private final FilmService filmService;

    @Autowired
    public FilmsController(FilmService filmService) {
        this.filmService = filmService;
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public FilmListDto getFilms() {
        return FilmListDto.of(filmService.getFilms(new GetFilmsQuery()));
    }

    @RequestMapping(value = "/{uuid}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public FilmDtoOut getFilm(@PathVariable("uuid") String uuid) {
        return FilmDtoOut.of(filmService.getFilm(new GetFilmQuery(UUID.fromString(uuid))));
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public FilmDtoOut createFilm(@RequestBody FilmDtoIn request) {
        CreateFilmCommand command = new CreateFilmCommand(
                request.getTitle(),
                Year.parse(request.getYear()),
                Genre.of(request.getGenre()),
                UUID.fromString(request.getDirectorId()),
                request.getCast().stream().collect(Collectors.toMap(RoleDto::getRoleName, role -> UUID.fromString(role.getActorId()))));
        return FilmDtoOut.of(filmService.createFilm(command));
    }

}
