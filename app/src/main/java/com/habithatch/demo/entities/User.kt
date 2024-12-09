package com.habithatch.demo.entities

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity()
data class User(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @Embedded val pet: Pet? = null
)
