package com.vicen.films.framework.infrastructure.jpa.dto;

import com.vicen.films.domain.films.Role;
import com.vicen.films.domain.people.StaffMember;

import javax.persistence.*;

@Entity
@Table(name = "ROLES")
public class RoleJpaDto implements Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "NAME")
    private String name;

    @ManyToOne
    private StaffMemberJpaDto actor;

    public static RoleJpaDto of(String name, StaffMemberJpaDto actor) {
        RoleJpaDto dto = new RoleJpaDto();
        dto.name = name;
        dto.actor = actor;
        return dto;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public StaffMember getActor() {
        return actor;
    }
}
