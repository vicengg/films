package com.vicen.films.application.service

import com.vicen.films.application.commands.CreateStaffMemberCommand
import com.vicen.films.application.queries.GetStaffMemberQuery
import com.vicen.films.application.queries.GetStaffQuery
import com.vicen.films.domain.people.StaffMember

interface StaffService {

    fun getStaff(query : GetStaffQuery = GetStaffQuery()): List<StaffMember>
    fun getStaffMember(query : GetStaffMemberQuery): StaffMember
    fun createStaffMember(command : CreateStaffMemberCommand): StaffMember

}