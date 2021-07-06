package com.vicen.films.application.queries

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

import java.util.UUID

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull

internal class GetFilmQueryTest {

    @Test
    @DisplayName("It instances the query from all its values.")
    fun instanceCompleteQuery() {
        val uuid = UUID.randomUUID()
        val (filmId) = GetFilmQuery(uuid)
        assertEquals(uuid, filmId)
    }

}
