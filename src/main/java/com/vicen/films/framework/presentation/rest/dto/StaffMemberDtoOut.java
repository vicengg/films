package com.vicen.films.framework.presentation.rest.dto;

import com.vicen.films.domain.Identifiable;
import com.vicen.films.domain.people.StaffMember;

import java.util.Objects;
import java.util.Optional;

public class StaffMemberDtoOut extends StaffMemberDtoIn {

    private String id;

    private StaffMemberDtoOut(String id, String name, String lastName, String birthDate) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    public static StaffMemberDtoOut of(StaffMember staffMember) {
        if (Objects.isNull(staffMember)) {
            return null;
        }
        return new StaffMemberDtoOut(
                Identifiable.getIdFrom(staffMember).toString(),
                staffMember.getName(),
                staffMember.getLastName(),
                Optional.ofNullable(staffMember.getBirthDate()).map(Objects::toString).orElse(null));
    }

    public String getId() {
        return id;
    }

}
