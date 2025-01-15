package com.habithatch.demo.data.mappers

import com.habithatch.demo.core.config.HabitHatchConfig
import com.habithatch.demo.data.entities.UserEntity
import com.habithatch.demo.data.models.UserModel
import javax.inject.Inject

class UserMapper
    @Inject
    constructor(
        private val config: HabitHatchConfig,
    ) : EntityModelMapper<UserEntity, UserModel> {
        override fun asEntity(model: UserModel): UserEntity =
            UserEntity(
                uuid = model.uuid,
                petId = model.pet.id,
            )

        @Throws(NoSuchElementException::class)
        override fun asModel(entity: UserEntity): UserModel {
            val pet = config.pets.first { it.id == entity.petId }
            return UserModel(
                uuid = entity.uuid,
                pet = pet,
            )
        }
    }
