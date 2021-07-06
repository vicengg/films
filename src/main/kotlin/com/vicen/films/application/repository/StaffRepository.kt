package com.vicen.films.application.repository

import com.vicen.films.domain.people.StaffMember
import java.util.UUID

interface StaffRepository {

    val staff: List<StaffMember>

    fun getStaffMember(staffMemberId: UUID): StaffMember

    fun createStaffMember(staffMember: StaffMember): StaffMember

}
