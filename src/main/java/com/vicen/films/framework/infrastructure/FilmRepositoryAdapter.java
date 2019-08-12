package com.vicen.films.framework.infrastructure;

import com.vicen.films.application.repository.FilmRepository;
import com.vicen.films.domain.Identifiable;
import com.vicen.films.domain.films.Film;
import com.vicen.films.domain.people.StaffMember;
import com.vicen.films.framework.errors.NotFoundError;
import com.vicen.films.framework.infrastructure.jpa.FilmJpaRepository;
import com.vicen.films.framework.infrastructure.jpa.StaffJpaRepository;
import com.vicen.films.framework.infrastructure.jpa.dto.FilmJpaDto;
import com.vicen.films.framework.infrastructure.jpa.dto.RoleJpaDto;
import com.vicen.films.framework.infrastructure.jpa.dto.StaffMemberJpaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class FilmRepositoryAdapter implements FilmRepository {

    private final FilmJpaRepository filmJpaRepository;
    private final StaffJpaRepository staffJpaRepository;

    @Autowired
    public FilmRepositoryAdapter(FilmJpaRepository filmJpaRepository, StaffJpaRepository staffJpaRepository) {
        this.filmJpaRepository = filmJpaRepository;
        this.staffJpaRepository = staffJpaRepository;
    }

    @Override
    public List<Film> getFilms() {
        return filmJpaRepository.findAll().stream().map(Film.class::cast).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public Film createFilm(Film film) {
        StaffMemberJpaDto director = retrieveFromJpa(film.getDirector());
        List<RoleJpaDto> cast = film.getCast().stream().map(
                role -> RoleJpaDto.of(role.getName(), retrieveFromJpa(role.getActor())))
                .collect(Collectors.toList());
        return filmJpaRepository.save(FilmJpaDto.of(film, director, cast));
    }


    private StaffMemberJpaDto retrieveFromJpa(StaffMember staffMember) {
        return staffJpaRepository.findById(Identifiable.getIdFrom(staffMember)).orElseThrow(NotFoundError::new);
    }

}
