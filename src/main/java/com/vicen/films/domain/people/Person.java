package com.vicen.films.domain.people;

import com.vicen.films.domain.Identifiable;

import java.time.LocalDate;

public interface Person {

    String getName();

    String getLastName();

    LocalDate getBirthDate();

}
