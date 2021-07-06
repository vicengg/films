package com.vicen.films.framework.presentation.rest.dto;

import com.vicen.films.domain.people.StaffMember;

import java.util.List;
import java.util.stream.Collectors;

public class StaffListDto {

    private final List<StaffMemberDtoOut> staff;

    private StaffListDto(List<StaffMemberDtoOut> staff) {
        this.staff = staff;
    }

    public static StaffListDto of(List<StaffMember> staff) {
        return new StaffListDto(staff.stream().map(StaffMemberDtoOut::new).collect(Collectors.toList()));
    }

    public List<StaffMemberDtoOut> getStaff() {
        return staff;
    }
}
