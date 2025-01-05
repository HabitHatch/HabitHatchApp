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
    /**
     * @suppress
     */
    @Deprecated(
        message = "Is only used in tests",
    )
    @Query("SELECT * FROM goal WHERE goal.id = :goalId")
    fun getGoalById(goalId: Long): Flow<GoalEntity?>

    @Query("SELECT * FROM goal")
    fun getAll(): Flow<List<GoalEntity>>

    @Insert
    suspend fun insert(goal: GoalEntity)

    @Insert()
    suspend fun insert(goals: Collection<GoalEntity>)

    /**
     * Updates the goal with the given [id] with the given [title], [statusLabel], and [priorityLabel].
     * [GoalEntity.createdAt] and [GoalEntity.id] are not allowed tto be updated.
     */
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

    /**
     * Deletes all goals from the database.
     */
    @Query("DELETE FROM goal")
    suspend fun deleteAll()
}
