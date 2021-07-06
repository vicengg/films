package com.vicen.films.domain.films

import com.vicen.films.domain.people.StaffMember

interface Role {

    val name: String
    val actor: StaffMember

}