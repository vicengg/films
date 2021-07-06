package com.vicen.films.domain

interface IdentifiableEnum {
    val id: String

    companion object {
        inline fun <reified T : Enum<T>> of(id : String) : T {
            return enumValues<T>().first{e -> when(e) {
                is IdentifiableEnum -> e.id == id
                else -> false
            }}
        }
    }

}