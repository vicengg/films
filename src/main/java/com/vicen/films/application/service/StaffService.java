package com.vicen.films.application.service;

import com.vicen.films.application.commands.CreateStaffMemberCommand;
import com.vicen.films.application.queries.GetStaffMemberQuery;
import com.vicen.films.application.queries.GetStaffQuery;
import com.vicen.films.domain.people.StaffMember;

import java.util.List;

public interface StaffService {

    List<StaffMember> getStaff(GetStaffQuery query);

    StaffMember getStaffMember(GetStaffMemberQuery query);

    StaffMember createStaffMember(CreateStaffMemberCommand command);
}

