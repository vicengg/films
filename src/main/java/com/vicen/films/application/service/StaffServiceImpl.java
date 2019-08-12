package com.vicen.films.application.service;

import com.vicen.films.application.commands.CreateStaffMemberCommand;
import com.vicen.films.application.queries.GetStaffMemberQuery;
import com.vicen.films.application.queries.GetStaffQuery;
import com.vicen.films.application.repository.StaffRepository;
import com.vicen.films.domain.people.StaffMember;
import com.vicen.films.domain.people.StaffMemberEntity;

import java.util.List;

public class StaffServiceImpl implements StaffService {

    private final StaffRepository staffRepository;

    public StaffServiceImpl(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

    @Override
    public List<StaffMember> getStaff(GetStaffQuery command) {
        return staffRepository.getStaff();
    }

    @Override
    public StaffMember getStaffMember(GetStaffMemberQuery query) {
        return staffRepository.getStaffMember(query.getStaffMemberId());
    }

    @Override
    public StaffMember createStaffMember(CreateStaffMemberCommand command) {
        StaffMember staffMember = StaffMemberEntity
                .builder()
                .withName(command.getName())
                .withLastName(command.getLastName())
                .withBirthDate(command.getBirthDate())
                .build();
        return staffRepository.createStaffMember(staffMember);
    }

}
