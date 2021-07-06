package com.vicen.films.domain.films

import com.vicen.films.domain.Entity
import com.vicen.films.domain.people.StaffMember
import java.time.Year
import java.util.*

class FilmEntity(override val title: String,
                 override val year: Year,
                 override val genre: Genre,
                 override val director: StaffMember,
                 override val cast: List<Role>) : Entity(id = UUID.randomUUID()), Film