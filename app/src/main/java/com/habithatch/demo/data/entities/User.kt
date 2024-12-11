package com.habithatch.demo.data.entities

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity
data class User(
    @PrimaryKey val uid: String = UUID.randomUUID().toString(),
    @Embedded val pet: Pet
)