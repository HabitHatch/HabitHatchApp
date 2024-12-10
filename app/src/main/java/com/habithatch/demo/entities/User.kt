package com.habithatch.demo.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity
data class User(
    @PrimaryKey val uid: String = UUID.randomUUID().toString(),
    val petId: Int
)