package com.habithatch.demo.data.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.habithatch.demo.data.entities.GoalEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface GoalDao {
    @Query("SELECT * FROM goal WHERE goal.id = :goalId")
    fun getGoalById(goalId: Int): Flow<GoalEntity?>

    @Query("SELECT * FROM goal")
    fun getAll(): Flow<List<GoalEntity>>

    @Insert
    suspend fun insert(goal: GoalEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(goals: Collection<GoalEntity>)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(goal: GoalEntity)

    @Query("DELETE FROM goal")
    suspend fun deleteAll()
}