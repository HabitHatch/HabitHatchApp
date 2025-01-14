package com.habithatch.demo.data.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.habithatch.demo.data.entities.UserEntity
import kotlinx.coroutines.flow.Flow

/**
 * The Data Access Object for the [UserEntity] class.
 */
@Dao
interface UserDao {
    @Query("SELECT * FROM user LIMIT 1")
    fun getUser(): Flow<UserEntity?>

    @Insert()
    suspend fun insert(user: UserEntity)

    /**
     * Deletes all users from the database.
     * But there should only be one user in the database.
     */
    @Query("DELETE FROM user")
    suspend fun deleteAll()
}
