package com.vicen.films.domain

import java.util.*

interface Identifiable {

    val id: UUID

    companion object {
        fun <T> getIdFrom(obj: T) : UUID {
            when (obj) {
                is Identifiable -> return obj.id;
            }
            throw NonIdentifiableException();
        }
    }

    class NonIdentifiableException : RuntimeException("Not identifiable object.")
}

