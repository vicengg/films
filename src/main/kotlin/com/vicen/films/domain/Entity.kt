package com.vicen.films.domain

import java.util.*

abstract class Entity(override val id: UUID) : Identifiable {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other?.javaClass != javaClass) return false
        when (other) {
            is Entity -> return other.id == this.id
        }
        return false
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }


}
