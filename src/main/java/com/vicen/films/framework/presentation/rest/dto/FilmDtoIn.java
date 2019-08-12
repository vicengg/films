package com.vicen.films.framework.presentation.rest.dto;

import java.util.List;

public class FilmDtoIn {

    protected String title;
    protected String year;
    protected String genre;
    protected String directorId;
    protected List<RoleDto> cast;

    public String getTitle() {
        return title;
    }

    public String getYear() {
        return year;
    }

    public String getGenre() {
        return genre;
    }

    public String getDirectorId() {
        return directorId;
    }

    public List<RoleDto> getCast() {
        return cast;
    }
}
