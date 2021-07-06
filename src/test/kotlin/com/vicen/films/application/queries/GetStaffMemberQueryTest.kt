package com.vicen.films.application.queries

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

import java.util.UUID

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull

internal class GetStaffMemberQueryTest {

    @Test
    @DisplayName("It instances the query from all its values.")
    fun instanceCompleteQuery() {
        val uuid = UUID.randomUUID()
        val (staffMemberId) = GetStaffMemberQuery(uuid)
        assertEquals(uuid, staffMemberId)
    }

}
