package com.habithatch.demo.data.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.habithatch.demo.data.entities.User
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Query("SELECT * FROM user LIMIT 1")
    fun getUser(): Flow<User?>

    @Insert()
    suspend fun insert(user: User)

    @Query("DELETE FROM user")
    suspend fun deleteAll()
}
