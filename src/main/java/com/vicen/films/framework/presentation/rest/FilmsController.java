package com.vicen.films.framework.presentation.rest;

import com.vicen.films.application.commands.CreateFilmCommand;
import com.vicen.films.application.queries.GetFilmsQuery;
import com.vicen.films.application.service.FilmService;
import com.vicen.films.domain.films.Genre;
import com.vicen.films.framework.presentation.rest.dto.FilmDtoIn;
import com.vicen.films.framework.presentation.rest.dto.FilmDtoOut;
import com.vicen.films.framework.presentation.rest.dto.FilmListDto;
import com.vicen.films.framework.presentation.rest.dto.RoleDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
