package com.vicen.films.application.service;

import com.vicen.films.application.commands.CreateFilmCommand;
import com.vicen.films.application.queries.GetFilmsQuery;
import com.vicen.films.application.repository.FilmRepository;
import com.vicen.films.application.repository.StaffRepository;
import com.vicen.films.domain.films.Film;
import com.vicen.films.domain.films.FilmEntity;
import com.vicen.films.domain.films.RoleVO;
import com.vicen.films.domain.people.StaffMember;

import java.util.List;
import java.util.stream.Collectors;

public class FilmServiceImpl implements FilmService {

    private final FilmRepository filmRepository;
    private final StaffRepository staffRepository;

    public FilmServiceImpl(FilmRepository filmRepository, StaffRepository staffRepository) {
        this.filmRepository = filmRepository;
        this.staffRepository = staffRepository;
    }

    @Override
    public List<Film> getFilms(GetFilmsQuery query) {
        return filmRepository.getFilms();
    }

    @Override
    public Film createFilm(CreateFilmCommand command) {
        StaffMember director = staffRepository.getStaffMember(command.getDirectorId());
        List<RoleVO> cast = command.getCast().entrySet()
                .stream()
                .map(entry -> RoleVO.of(entry.getKey(), staffRepository.getStaffMember(entry.getValue())))
                .collect(Collectors.toList());
        Film film = FilmEntity.builder()
                .withTitle(command.getTitle())
                .withYear(command.getYear())
                .withGenre(command.getGenre())
                .withDirector(director)
                .withCast(cast)
                .build();
        return filmRepository.createFilm(film);
    }

}
