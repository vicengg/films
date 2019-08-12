package com.vicen.films.domain.films;

import com.vicen.films.domain.people.StaffMember;

public class RoleVO implements Role {

    private final String name;
    private final StaffMember actor;

    private RoleVO(String name, StaffMember actor) {
        this.name = name;
        this.actor = actor;
    }

    public static RoleVO of(String name, StaffMember actor) {
        return new RoleVO(name, actor);
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
