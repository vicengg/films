package com.vicen.films.application.commands;

import com.vicen.films.domain.films.Genre;

import java.time.Year;
import java.util.Map;
import java.util.UUID;

public class CreateFilmCommand implements Command {

    private final String title;
    private final Year year;
    private final Genre genre;
    private final UUID directorId;
    private final Map<String, UUID> cast;

    public CreateFilmCommand(String title, Year year, Genre genre, UUID directorId, Map<String, UUID> cast) {
        this.title = title;
        this.year = year;
        this.genre = genre;
        this.directorId = directorId;
        this.cast = cast;
    }

    public String getTitle() {
        return title;
    }

    public Year getYear() {
        return year;
    }

    public Genre getGenre() {
        return genre;
    }

    public UUID getDirectorId() {
        return directorId;
    }

    public Map<String, UUID> getCast() {
        return cast;
    }
}
