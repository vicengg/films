package com.vicen.films.domain.films;

import com.vicen.films.domain.Entity;
import com.vicen.films.domain.people.StaffMember;

import java.time.Year;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class FilmEntity extends Entity implements Film {

    private final String title;
    private final Year year;
    private final Genre genre;
    private final StaffMember director;
    private final List<Role> cast;

    private FilmEntity(FilmBuilder builder) {
        super(UUID.randomUUID());
        this.title = builder.title;
        this.year = builder.year;
        this.genre = builder.genre;
        this.director = builder.director;
        this.cast = builder.cast;
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
        return cast;
    }

    public static FilmBuilder builder() {
        return new FilmBuilder();
    }

    public static class FilmBuilder {
        private String title;
        private Year year;
        private Genre genre;
        private StaffMember director;
        private List<Role> cast;

        public FilmBuilder withTitle(String title) {
            this.title = title;
            return this;
        }

        public FilmBuilder withYear(Year year) {
            this.year = year;
            return this;
        }

        public FilmBuilder withGenre(Genre genre) {
            this.genre = genre;
            return this;
        }

        public FilmBuilder withDirector(StaffMember director) {
            this.director = director;
            return this;
        }

        public <T extends Role> FilmBuilder withCast(List<T> cast) {
            this.cast = cast.stream().map(Role.class::cast).collect(Collectors.toList());
            return this;
        }

        public FilmEntity build() {
            return new FilmEntity(this);
        }

    }

}
