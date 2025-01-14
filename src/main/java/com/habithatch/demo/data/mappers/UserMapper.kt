package com.habithatch.demo.data.mappers

import com.habithatch.demo.core.config.HabitHatchConfig
import javax.inject.Inject

class UserMapper
@Inject constructor(
        config: HabitHatchConfig
) {
    fun asEntity(model: UserModel): UserEntity {
        return UserEntity(
                uuid = model.uuid,
                pet = model.pet,
                mood = config.defaultMood
        )
    }

    fun asModel(entity: UserEntity): UserModel {
        return UserModel(
                uuid = entity.uuid,
                pet = entity.pet
        )
    }q
}
