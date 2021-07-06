package com.vicen.films.application.commands

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

import java.time.LocalDate

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull

internal class CreateStaffMemberCommandTest {

    @Test
    @DisplayName("It instances the command from all its values.")
    fun instanceCompleteCommand() {
        val name = "Name"
        val lastName = "LastName"
        val birthDate = LocalDate.now()
        val command = CreateStaffMemberCommand(name, lastName, birthDate)
        assertEquals(name, command.name)
        assertEquals(lastName, command.lastName)
        assertEquals(birthDate, command.birthDate)
    }

}
