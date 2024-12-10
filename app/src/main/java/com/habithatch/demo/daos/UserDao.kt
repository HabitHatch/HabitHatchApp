package com.habithatch.demo.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.habithatch.demo.entities.User

@Dao
interface UserDao {
    @Query("SELECT * FROM user LIMIT 1")
    suspend fun getUser(): User?

    @Insert()
    suspend fun insert(user: User)

    @Query("DELETE FROM user")
    suspend fun delete()
}
