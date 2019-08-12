package com.vicen.films.domain.people;

import com.vicen.films.domain.Entity;

import java.util.UUID;

public abstract class PersonEntity extends Entity implements Person {
    
    protected PersonEntity(UUID id) {
        super(id);
    }
}
