package com.vicen.films.domain.films

import com.vicen.films.domain.people.StaffMember
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.mockito.Mockito.mock
import java.time.Year

internal class FilmEntityTest {

    @Test
    @DisplayName("It creates a complete film from its value objects.")
    fun createCompleteFilm() {
        val title = "Title"
        val year = Year.now()
        val genre = Genre.ADVENTURE
        val director = mock(StaffMember::class.java)
        val role = mock(Role::class.java)
        val film = FilmEntity(
                title = title,
                year = year,
                genre = genre,
                director = director,
                cast = listOf(role)
        )
        assertEquals(title, film.title)
        assertEquals(year, film.year)
        assertEquals(genre, film.genre)
        assertEquals(director, film.director)
        assertEquals(listOf(role), film.cast)
    }

}

