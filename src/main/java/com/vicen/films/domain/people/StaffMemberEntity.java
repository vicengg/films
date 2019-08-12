package com.vicen.films.domain.people;

import java.time.LocalDate;
import java.util.UUID;

public class StaffMemberEntity extends PersonEntity implements StaffMember {

    private final String name;
    private final String lastName;
    private final LocalDate birthDate;

    private StaffMemberEntity(StaffMemberBuilder builder) {
        super(UUID.randomUUID());
        this.name = builder.name;
        this.lastName = builder.lastName;
        this.birthDate = builder.birthDate;
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

    public static StaffMemberBuilder builder() {
        return new StaffMemberBuilder();
    }

    public static class StaffMemberBuilder {
        private String name;
        private String lastName;
        private LocalDate birthDate;

        private StaffMemberBuilder() {
        }

        public StaffMemberBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public StaffMemberBuilder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public StaffMemberBuilder withBirthDate(LocalDate birthDate) {
            this.birthDate = birthDate;
            return this;
        }

        public StaffMemberEntity build() {
            return new StaffMemberEntity(this);
        }

    }

}
