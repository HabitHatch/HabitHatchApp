package com.habithatch.demo.data.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.habithatch.demo.data.entities.Goal
import kotlinx.coroutines.flow.Flow

@Dao
interface GoalDao {
    @Query("SELECT * FROM goal WHERE goal.id = :goalId")
    suspend fun getGoalById(goalId: Int): Goal?

    @Query("SELECT * FROM goal")
    fun getAll(): Flow<List<Goal>>

    @Query("SELECT * FROM goal WHERE NOT isDone")
    fun getAllActive(): Flow<List<Goal>>

    @Insert
    suspend fun insert(goal: Goal)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(goal: Goal)
}