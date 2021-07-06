package com.vicen.films.domain.films

import com.vicen.films.domain.people.StaffMember

data class RoleVO(override val name : String, override val actor: StaffMember) : Role