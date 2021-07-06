package com.vicen.films.domain.people

import java.time.LocalDate

class StaffMemberEntity(name: String, lastName: String, birthDate: LocalDate) : PersonEntity(name, lastName, birthDate), StaffMember