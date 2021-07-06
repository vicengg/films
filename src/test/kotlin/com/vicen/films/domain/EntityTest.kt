package com.vicen.films.domain

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

import java.util.UUID

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotEquals

internal class EntityTest {

    private class ExtendedEntity internal constructor(id: UUID) : Entity(id)

    private class OtherExtendedEntity internal constructor(id: UUID) : Entity(id)

    @Test
    @DisplayName("Tests entity constructor.")
    fun constructorTest() {
        val uuid = UUID.randomUUID()
        val entity = ExtendedEntity(uuid)
        assertEquals(uuid, entity.id)
    }

    @Test
    @DisplayName("Tests that two entities of the same class are equals if their IDs are equals.")
    fun equalsTest() {
        val uuid = UUID.randomUUID()
        val entity1 = ExtendedEntity(uuid)
        val entity2 = ExtendedEntity(uuid)
        assertEquals(entity1, entity2)
    }

    @Test
    @DisplayName("Tests that two entities of different classes are not equals although their IDs are equals.")
    fun equalsTestWhenClassesAreDifferent() {
        val uuid = UUID.randomUUID()
        val entity1 = ExtendedEntity(uuid)
        val entity2 = OtherExtendedEntity(uuid)
        assertNotEquals(entity1, entity2)
    }

}
