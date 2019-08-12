package com.vicen.films.domain.films;

import com.vicen.films.domain.people.StaffMember;

public interface Role {
    String getName();
    StaffMember getActor();
}
