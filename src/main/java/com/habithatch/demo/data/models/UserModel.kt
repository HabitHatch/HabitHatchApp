package com.habithatch.demo.data.models

import com.habithatch.demo.data.entities.Pet
import java.util.UUID

data class UserModel(
    val uuid: UUID,
    val pet: Pet
)
