package com.vicen.films.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.util.*

internal class IdentifiableTest {

    @Test
    @DisplayName("Gets the ID of an identifiable object.")
    fun getIdOfIdentifiable() {
        val uuid = UUID.randomUUID()
        val resultUuid = Identifiable.getIdFrom<Identifiable>(object : Identifiable {
            override val id: UUID = uuid
        })
        assertEquals(uuid, resultUuid)
    }

    @Test
    @DisplayName("Tries to get the ID of an non-identifiable object.")
    fun getIdOfNonIdentifiable() {
        val nonIdentifiable = Any()
        val exception = assertThrows(Identifiable.NonIdentifiableException::class.java
        ) { Identifiable.getIdFrom(nonIdentifiable) }
        assertEquals("Not identifiable object.", exception.message)
    }

}
