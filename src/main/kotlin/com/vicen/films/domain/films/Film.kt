package com.vicen.films.domain.films

import com.vicen.films.domain.people.StaffMember
import java.time.Year

interface Film {

    val title: String
    val year: Year
    val genre: Genre
    val director: StaffMember
    val cast: List<Role>

}