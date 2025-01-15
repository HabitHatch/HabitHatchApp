package com.habithatch.demo.data.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.habithatch.demo.data.entities.HabitEntity
import kotlinx.coroutines.flow.Flow

/**
 * The Data Access Object for the [HabitEntity] class.
 */
@Dao
interface HabitDao {
    /**
     * @suppress
     */
    @Deprecated(
        message = "Is only used in tests",
    )
    @Query("SELECT * FROM habit WHERE habit.id = :habitId")
    fun getHabitById(habitId: Long): Flow<HabitEntity?>

    @Query("SELECT * FROM habit")
    fun getAll(): Flow<List<HabitEntity>>

    @Insert
    suspend fun insert(habit: HabitEntity)

    @Insert()
    suspend fun insert(habits: Collection<HabitEntity>)

    /**
     * Updates the habit with the given [id] with the given [title], [statusLabel], and [priorityLabel].
     * [HabitEntity.createdAt] and [HabitEntity.id] are not allowed tto be updated.
     */
    @Query(
        """
        UPDATE habit
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
     * Deletes all habits from the database.
     */
    @Query("DELETE FROM habit")
    suspend fun deleteAll()
}
