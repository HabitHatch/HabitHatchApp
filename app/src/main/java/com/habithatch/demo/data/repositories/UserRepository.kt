package com.habithatch.demo.data.repositories

import com.habithatch.demo.core.util.isValidUuid
import com.habithatch.demo.data.daos.UserDao
import com.habithatch.demo.data.entities.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first

class UserRepository(private val userDao: UserDao) {
    fun getUser(): Flow<User?> {
        return userDao.getUserFlow()
    }

    suspend fun createUser(user: User): User {
        val existingUser = this.getUser().first()
        if (existingUser != null) {
            throw IllegalStateException("A user already exists. Delete the current user before creating a new one.")
        }
        if (!isValidUuid(user.uid)) {
            throw IllegalArgumentException("Invalid UUID format for user ID.")
        }
        userDao.insert(user)
        return user
    }


    suspend fun deleteUser() {
        userDao.delete()
    }
}
