package com.vicen.films.framework.infrastructure.jpa.dto;

import com.vicen.films.domain.Identifiable;
import com.vicen.films.domain.films.Film;
import com.vicen.films.domain.films.Genre;
import com.vicen.films.domain.films.Role;
import com.vicen.films.domain.people.StaffMember;

import javax.persistence.*;
import java.text.MessageFormat;
import java.time.Year;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Entity
@Table(name = "FILMS")
public class FilmJpaDto implements Film, Identifiable {

    @Id
    @Column(name = "ID")
    private UUID id;
    @Column(name = "TITLE")
    private String title;
    @Column(name = "YEAR")
    private Year year;
    @Column(name = "GENRE")
    private Genre genre;
    @ManyToOne
    private StaffMemberJpaDto director;
    @OneToMany(cascade= CascadeType.ALL, fetch = FetchType.EAGER)
    private List<RoleJpaDto> cast;

    public static FilmJpaDto of(Film film, StaffMemberJpaDto director, List<RoleJpaDto> cast) {
        FilmJpaDto jpaDto = new FilmJpaDto();
        jpaDto.id = Identifiable.getIdFrom(film);
        jpaDto.title = film.getTitle();
        jpaDto.year = film.getYear();
        jpaDto.genre = film.getGenre();
        jpaDto.director = director;
        jpaDto.cast = cast;
        return jpaDto;
    }

    @Override
    public UUID getId() {
        return id;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public Year getYear() {
        return year;
    }

    @Override
    public Genre getGenre() {
        return genre;
    }

    @Override
    public StaffMember getDirector() {
        return director;
    }

    @Override
    public List<Role> getCast() {
        return cast.stream().map(Role.class::cast).collect(Collectors.toList());
    }

}
