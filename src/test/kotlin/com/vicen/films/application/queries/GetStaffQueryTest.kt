package com.vicen.films.application.queries

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.assertNotNull

internal class GetStaffQueryTest {

    @Test
    @DisplayName("It instances the query.")
    fun instanceCompleteQuery() {
        val query = GetStaffQuery()
        assertNotNull(query)
    }

}
