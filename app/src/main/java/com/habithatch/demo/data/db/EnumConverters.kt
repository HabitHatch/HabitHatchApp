package com.habithatch.demo.data.db

import androidx.room.TypeConverter
import com.habithatch.demo.data.entities.GoalStatus
import com.habithatch.demo.data.entities.GoalPriority

class EnumConverters {
    @TypeConverter
    fun fromGoalState(state: GoalStatus): String {
        return state.name
    }

    @TypeConverter
    fun toGoalState(state: String): GoalStatus {
        return GoalStatus.valueOf(state)
    }
}