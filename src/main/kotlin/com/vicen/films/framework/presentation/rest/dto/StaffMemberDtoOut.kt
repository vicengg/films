package com.vicen.films.framework.presentation.rest.dto

import com.vicen.films.domain.Identifiable
import com.vicen.films.domain.people.StaffMember

class StaffMemberDtoOut() : StaffMemberDtoIn() {

    var id: String? = null

    constructor(staffMember: StaffMember) : this() {
        id =  Identifiable.getIdFrom(staffMember).toString()
        name = staffMember.name
        lastName = staffMember.lastName
        birthDate = staffMember.birthDate.toString()
    }

}