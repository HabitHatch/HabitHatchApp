package com.habithatch.demo.data.mappers

import android.util.Log

import com.habithatch.demo.core.config.HabitHatchConfig
import com.habithatch.demo.data.entities.UserEntity
import com.habithatch.demo.data.models.UserModel
import javax.inject.Inject

class UserMapper
    @Inject
    constructor(
        private val config: HabitHatchConfig,
    ) {
        fun asEntity(model: UserModel): UserEntity =
            UserEntity(
                uuid = model.uuid,
                petId = model.pet.id,
            )

        @Throws(NoSuchElementException::class)
        fun asModel(entity: UserEntity): UserModel {
            val pet = config.getPetById(entity.petId)
            Log.d("UserMapper", "Pet: $pet")
            return UserModel(
                uuid = entity.uuid,
                pet = pet,
            )
        }
    }
