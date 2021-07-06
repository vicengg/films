package com.vicen.films.domain.people

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

import java.time.LocalDate

import org.junit.jupiter.api.Assertions.assertEquals

internal class StaffMemberEntityTest {

    @Test
    @DisplayName("It creates a complete staff member from its value objects.")
    fun createCompleteStaffMember() {
        val name = "Name"
        val lastName = "LastName"
        val birthDate = LocalDate.now()
        val staffMember = StaffMemberEntity(name, lastName, birthDate)
        assertEquals(name, staffMember.name)
        assertEquals(lastName, staffMember.lastName)
        assertEquals(birthDate, staffMember.birthDate)
    }

}

