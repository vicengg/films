package com.vicen.films.application.service

import com.vicen.films.application.commands.CreateStaffMemberCommand
import com.vicen.films.application.queries.GetStaffMemberQuery
import com.vicen.films.application.queries.GetStaffQuery
import com.vicen.films.application.repository.StaffRepository
import com.vicen.films.domain.people.StaffMember
import com.vicen.films.domain.people.StaffMemberEntity

class StaffServiceImpl(val staffRepository: StaffRepository) : StaffService {

    override fun getStaff(query: GetStaffQuery): List<StaffMember> = staffRepository.staff

    override fun getStaffMember(query: GetStaffMemberQuery): StaffMember = staffRepository.getStaffMember(query.staffMemberId)

    override fun createStaffMember(command: CreateStaffMemberCommand): StaffMember {
        val staffMember = StaffMemberEntity(command.name, command.lastName, command.birthDate);
        return staffRepository.createStaffMember(staffMember);
    }
}