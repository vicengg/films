package com.vicen.films.application.service

import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import com.vicen.films.application.commands.CreateStaffMemberCommand
import com.vicen.films.application.queries.GetStaffMemberQuery
import com.vicen.films.application.queries.GetStaffQuery
import com.vicen.films.application.repository.StaffRepository
import com.vicen.films.domain.people.StaffMember
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.time.LocalDate
import java.util.*

internal class StaffServiceTest {

    private val staffMember: StaffMember = mock();
    private val staffRepository: StaffRepository = mock();
    private val staffService: StaffService = StaffServiceImpl(staffRepository);

    @Test
    @DisplayName("Tests get staff method behaviour when query is passed.")
    fun getStaffTestWhenQueryIsPassed() {
        whenever(staffRepository.staff).thenReturn(listOf(staffMember))
        val result = staffService.getStaff(GetStaffQuery())
        assertTrue(result.contains(staffMember))
    }

    @Test
    @DisplayName("Tests get staff method behaviour when query isn't passed.")
    fun getStaffTestWhenQueryIsNotPassed() {
        whenever(staffRepository.staff).thenReturn(listOf(staffMember))
        val result = staffService.getStaff()
        assertTrue(result.contains(staffMember))
    }

    @Test
    @DisplayName("Tests get staff member method behaviour.")
    fun getStaffMemberTest() {
        val staffMemberId = UUID.randomUUID();
        whenever(staffRepository.getStaffMember(staffMemberId)).thenReturn(staffMember)
        val result = staffService.getStaffMember(GetStaffMemberQuery(staffMemberId))
        assertEquals(staffMember, result)
    }

    @Test
    @DisplayName("Tests create staff member method behaviour.")
    fun createStaffMemberTest() {
        whenever(staffRepository.createStaffMember(any())).thenReturn(staffMember)
        val command = CreateStaffMemberCommand(name = "Name", lastName = "LastName", birthDate = LocalDate.now());
        val result = staffService.createStaffMember(command)
        assertEquals(staffMember, result)
    }

}