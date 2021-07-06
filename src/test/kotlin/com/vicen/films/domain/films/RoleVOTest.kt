package com.vicen.films.domain.films

import com.vicen.films.domain.people.StaffMember
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

import org.junit.Assert.assertEquals
import org.mockito.Mockito.mock

internal class RoleVOTest {

    @Test
    @DisplayName("It creates a film role from its name and actor.")
    fun createRoleFromNameAndActor() {
        val name = "Name"
        val actor = mock(StaffMember::class.java)
        val role = RoleVO(name = name, actor = actor)
        assertEquals(name, role.name)
        assertEquals(actor, role.actor)
    }

}
