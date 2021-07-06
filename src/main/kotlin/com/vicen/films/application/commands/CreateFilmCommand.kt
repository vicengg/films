package com.vicen.films.application.commands;

import com.vicen.films.domain.films.Genre;

import java.time.Year;
import java.util.UUID;

data class CreateFilmCommand(val title: String,
                             val year: Year,
                             val genre: Genre,
                             val directorId: UUID,
                             val cast: List<Pair<String, UUID>>) : Command

