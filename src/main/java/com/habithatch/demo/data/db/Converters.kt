package com.habithatch.demo.data.db

import androidx.room.TypeConverter
import com.habithatch.demo.core.exceptions.InvalidUUIdException
import java.time.Instant
import java.util.UUID

/**
 * [Converters] is a class that provides type converters for Room.
 * Converts between UUID and String and Instant and String.
 */
class Converters {
    @TypeConverter
    fun toInstant(value: String): Instant = Instant.parse(value)

    @TypeConverter
    fun fromInstant(instant: Instant): String = instant.toString()

    @TypeConverter
    @Throws(InvalidUUIdException::class)
    fun toUUID(value: String): UUID {
        try {
            return UUID.fromString(value)
        } catch (e: IllegalArgumentException) {
            throw InvalidUUIdException(value, e)
        }
    }

    @TypeConverter
    fun fromUUID(uuid: UUID): String = uuid.toString()
}
