package com.vicen.films.domain.people;

import java.time.LocalDate;
import java.util.UUID;

public class UserEntity extends PersonEntity implements User {

    protected UserEntity(UUID id) {
        super(id);
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getLastName() {
        return null;
    }

    @Override
    public LocalDate getBirthDate() {
        return null;
    }
}
