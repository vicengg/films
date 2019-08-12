package com.vicen.films.application.commands;

import com.vicen.films.domain.people.StaffMember;

import java.time.LocalDate;

public class CreateStaffMemberCommand implements Command {

    private String name;
    private String lastName;
    private LocalDate localDate;

    public CreateStaffMemberCommand(String name, String lastName, LocalDate localDate) {
        this.name = name;
        this.lastName = lastName;
        this.localDate = localDate;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getBirthDate() {
        return localDate;
    }
}
