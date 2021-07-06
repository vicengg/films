package com.vicen.films.domain.people

import java.time.LocalDate

interface Person {

    val name: String
    val lastName: String
    val birthDate: LocalDate

}