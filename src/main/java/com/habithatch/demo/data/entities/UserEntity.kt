package com.habithatch.demo.data.entities

import androidx.compose.runtime.Immutable
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

/**
 * [UserEntity] represents a user.
 *
 * @param uuid the UUID of the user, for global identification
 * @param petId the pet of the user
 */
@Immutable
@Entity(tableName = "user")
data class UserEntity(
    @PrimaryKey val uuid: UUID = UUID.randomUUID(),
    val petId: Int,
)
