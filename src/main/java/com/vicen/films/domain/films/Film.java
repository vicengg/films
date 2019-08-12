package com.vicen.films.domain.films;

import com.vicen.films.domain.Aggregate;
import com.vicen.films.domain.people.StaffMember;

import java.time.Year;
import java.util.List;

public interface Film extends Aggregate {

    String getTitle();

    Year getYear();

    Genre getGenre();

    StaffMember getDirector();

    List<Role> getCast();

}
