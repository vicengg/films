package com.vicen.films.domain.people

import com.vicen.films.domain.Entity
import java.time.LocalDate
import java.util.*

abstract class PersonEntity(
        override val name: String,
        override val lastName: String,
        override val birthDate: LocalDate) : Entity(UUID.randomUUID()), Person