package com.habithatch.demo.data.entities

import java.util.UUID
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey val uuid: String = UUID.randomUUID().toString(),
    @Embedded val pet: Pet
)