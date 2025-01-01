package com.habithatch.demo.data.entities

import androidx.compose.runtime.Immutable
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

/**
 * [User] represents a user.
 *
 * @param uuid the UUID of the user, for global identification
 * @param pet the pet of the user
 */
@Immutable
@Entity
data class User(
    @PrimaryKey val uuid: UUID = UUID.randomUUID(),
    @Embedded val pet: Pet,
)
