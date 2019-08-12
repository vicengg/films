package com.vicen.films.framework.presentation.rest.dto;

import com.vicen.films.domain.Identifiable;
import com.vicen.films.domain.films.Role;

import java.util.Objects;

public class RoleDto {

    private String roleName;
    private String actorId;

    public static RoleDto of(Role role) {
        RoleDto dto = new RoleDto();
        dto.roleName = role.getName();
        dto.actorId = Identifiable.getIdFrom(role.getActor()).toString();
        return dto;
    }

    public String getRoleName() {
        return roleName;
    }

    public String getActorId() {
        return actorId;
    }
}

