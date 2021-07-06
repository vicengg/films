package com.vicen.films.application.service

import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import com.vicen.films.application.commands.CreateFilmCommand
import com.vicen.films.application.queries.GetFilmQuery
import com.vicen.films.application.queries.GetFilmsQuery
import com.vicen.films.application.repository.FilmRepository
import com.vicen.films.application.repository.StaffRepository
import com.vicen.films.domain.films.Film
import com.vicen.films.domain.films.Genre
import com.vicen.films.domain.people.StaffMember
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.mockito.ArgumentMatchers
import java.time.Year
import java.util.*

internal class FilmServiceTest {

    private val staffMember: StaffMember = mock()
    private val film: Film = mock();
    private val filmRepository: FilmRepository = mock()
    private val staffRepository: StaffRepository = mock()
    private val filmService: FilmService = FilmServiceImpl(filmRepository, staffRepository)

    @Test
    @DisplayName("Tests get films method behaviour when query is passed.")
    fun getFilmsTestWhenQueryIsPassed() {
        whenever(filmRepository.films).thenReturn(listOf(film))
        val result = filmService.getFilms(GetFilmsQuery())
        assertTrue(result.contains(film))
    }

    @Test
    @DisplayName("Tests get films method behaviour when query isn't passed.")
    fun getFilmsTestWhenQueryIsNotPassed() {
        whenever(filmRepository.films).thenReturn(listOf(film))
        val result = filmService.getFilms()
        assertTrue(result.contains(film))
    }

    @Test
    @DisplayName("Tests get film method behaviour.")
    fun getFilmTest() {
        val filmId = UUID.randomUUID();
        whenever(filmRepository.getFilm(filmId)).thenReturn(film)
        val result = filmService.getFilm(GetFilmQuery(filmId))
        assertEquals(film, result)
    }

    @Test
    @DisplayName("Tests create film method behaviour.")
    fun createFilmTest() {
        whenever(staffRepository.getStaffMember(any())).thenReturn(staffMember)
        whenever(filmRepository.createFilm(any())).thenReturn(film)
        val result = filmService.createFilm(CreateFilmCommand(
                title = "Title",
                year = Year.now(),
                genre = Genre.ADVENTURE,
                directorId = UUID.randomUUID(),
                cast = listOf(Pair("RoleName", UUID.randomUUID()))))
        assertEquals(film, result)
    }

}