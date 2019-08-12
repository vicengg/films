package com.vicen.films.application.repository;

import com.vicen.films.application.commands.CreateStaffMemberCommand;
import com.vicen.films.application.queries.GetStaffMemberQuery;
import com.vicen.films.application.queries.GetStaffQuery;
import com.vicen.films.domain.people.StaffMember;

import java.util.List;
import java.util.UUID;

public interface StaffRepository {

    List<StaffMember> getStaff();

    StaffMember getStaffMember(UUID staffMemberId);

    StaffMember createStaffMember(StaffMember staffMember);

}
