package com.vicen.films.framework.infrastructure.jpa.dto;

import com.vicen.films.domain.Identifiable;
import com.vicen.films.domain.people.Person;
import com.vicen.films.domain.people.StaffMember;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "STAFF_MEMBERS")
public class StaffMemberJpaDto implements Identifiable, StaffMember {

    @Id
    @Column(name = "ID")
    private UUID id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "BIRTH_DATE")
    private LocalDate birthDate;

    public static StaffMemberJpaDto of(StaffMember staffMember) {
        StaffMemberJpaDto jpaDto = new StaffMemberJpaDto();
        jpaDto.id = Identifiable.Companion.getIdFrom(staffMember);
        jpaDto.name = staffMember.getName();
        jpaDto.lastName = staffMember.getLastName();
        jpaDto.birthDate = staffMember.getBirthDate();
        return jpaDto;
    }

    @Override
    public UUID getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public LocalDate getBirthDate() {
        return birthDate;
    }

}
