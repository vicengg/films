package com.vicen.films.domain.films

import com.vicen.films.domain.IdentifiableEnum

enum class Genre(override val id: String) : IdentifiableEnum {
    ADVENTURE("adventure"),
    COMEDY("comedy"),
    DRAMA("drama"),
    HORROR("horror"),
    MUSICAL("musical"),
    SCI_FI("sci-fi"),
    WAR("war"),
    WESTERN("western"),
    THRILLER("thriller");

    override fun toString(): String {
        return this.id
    }

}