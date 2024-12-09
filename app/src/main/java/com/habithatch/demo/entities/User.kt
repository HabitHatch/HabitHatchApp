package com.habithatch.demo.entities

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity()
data class User(
    @PrimaryKey() val id: Int = 1,
    @Embedded val pet: Pet? = null
)
