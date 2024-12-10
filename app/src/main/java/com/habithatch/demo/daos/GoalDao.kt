package com.habithatch.demo.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.habithatch.demo.entities.Goal

@Dao
interface GoalDao {
    @Query("SELECT * FROM goal WHERE goal.id = :goalId")
    suspend fun getGoalById(goalId: Int): Goal?

    @Query("SELECT * FROM goal")
    suspend fun getAll(): List<Goal>

    @Query("SELECT * FROM goal WHERE NOT isDone")
    suspend fun getAllActive(): List<Goal>

    @Insert()
    suspend fun insert(goal: Goal)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(goal: Goal)
}