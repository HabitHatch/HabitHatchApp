package com.habithatch.demo.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Goal(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val title: String,
    val isDone: Boolean = false
)