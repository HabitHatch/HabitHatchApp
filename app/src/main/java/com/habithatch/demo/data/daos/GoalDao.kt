package com.habithatch.demo.data.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.habithatch.demo.data.entities.GoalEntity
import kotlinx.coroutines.flow.Flow

/**
 * The Data Access Object for the [GoalEntity] class.
 */
@Dao
interface GoalDao {
    @Query("SELECT * FROM goal WHERE goal.id = :goalId")
    fun getGoalById(goalId: Long): Flow<GoalEntity?>

    @Query("SELECT * FROM goal")
    fun getAll(): Flow<List<GoalEntity>>

    @Insert
    suspend fun insert(goal: GoalEntity)

    @Insert()
    suspend fun insertAll(goals: Collection<GoalEntity>)

    @Query(
        """
        UPDATE goal
        SET title = :title,
            statusLabel = :statusLabel,
            priorityLabel = :priorityLabel
        WHERE id = :id
    """,
    )
    suspend fun update(
        id: Long,
        title: String,
        statusLabel: String,
        priorityLabel: String,
    )

    @Query("DELETE FROM goal")
    suspend fun deleteAll()
}
