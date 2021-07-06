package com.vicen.films.domain.films

import com.vicen.films.domain.IdentifiableEnum
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class GenreTest {

    @ParameterizedTest
    @ValueSource(strings = arrayOf("adventure", "comedy", "drama", "horror", "musical", "sci-fi", "war", "western", "thriller"))
    @DisplayName("It retrieves a genre from its genre ID.")
    fun obtainExistingGenre(genreId : String) {
        val genre = IdentifiableEnum.of<Genre>(genreId)
        assertEquals(genreId, genre.id);
        assertEquals(genreId, genre.toString());
    }

    @Test
    @DisplayName("It tries to obtain an enum value from a non-existent identifier")
    fun getIdentifiableEnumFromNonExistentId() {
        assertThrows<NoSuchElementException> { IdentifiableEnum.of<Genre>("unknown_genre") }
    }

}