package com.habithatch.demo.data.db

import androidx.room.TypeConverter
import com.habithatch.demo.data.entities.GoalDoneState
import com.habithatch.demo.data.entities.GoalPriority

class Converters {

    @TypeConverter
    fun fromGoalPriority(priority: GoalPriority): String {
        return priority.name
    }

    @TypeConverter
    fun toGoalPriority(priority: String): GoalPriority {
        return GoalPriority.valueOf(priority)
    }

    @TypeConverter
    fun fromGoalState(state: GoalDoneState): String {
        return state.name
    }

    @TypeConverter
    fun toGoalState(state: String): GoalDoneState {
        return GoalDoneState.valueOf(state)
    }
}