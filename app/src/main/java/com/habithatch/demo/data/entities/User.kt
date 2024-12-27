package com.habithatch.demo.data.entities

import androidx.compose.runtime.Immutable
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Immutable
@Entity
data class User(
    @PrimaryKey val uuid: UUID = UUID.randomUUID(),
    @Embedded val pet: Pet,
)
