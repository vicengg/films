package com.vicen.films.application.queries;

import java.util.UUID;

public class GetStaffMemberQuery implements Query {

    private final UUID staffMemberId;

    public GetStaffMemberQuery(UUID staffMemberId) {
        this.staffMemberId = staffMemberId;
    }

    public UUID getStaffMemberId() {
        return staffMemberId;
    }
}
