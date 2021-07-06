package com.vicen.films.application.commands

import com.vicen.films.domain.films.Genre
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

import java.time.Year
import java.util.HashMap
import java.util.UUID

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull

internal class CreateFilmCommandTest {

    @Test
    @DisplayName("It instances the command from all its values.")
    fun instanceCompleteCommand() {
        val title = "Title"
        val year = Year.now()
        val genre = Genre.ADVENTURE
        val directorId = UUID.randomUUID()
        val cast = listOf<Pair<String, UUID>>()
        val (title1, year1, genre1, directorId1, cast1) = CreateFilmCommand(title, year, genre, directorId, cast)
        assertEquals(title, title1)
        assertEquals(year, year1)
        assertEquals(genre, genre1)
        assertEquals(directorId, directorId1)
        assertEquals(cast, cast1)
    }

}
