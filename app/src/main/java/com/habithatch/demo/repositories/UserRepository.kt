package com.habithatch.demo.repositories

import com.habithatch.demo.daos.UserDao
import com.habithatch.demo.entities.User
import com.habithatch.demo.util.isValidUuid

class UserRepository(private val userDao: UserDao) {
    suspend fun getUser(): User? {
        return userDao.getUser()
    }

    suspend fun createUser(user: User): User {
        val existingUser = userDao.getUser()
        if (existingUser != null) {
            throw IllegalStateException("A user already exists. Delete the current user before creating a new one.")
        }
        if(!isValidUuid(user.uid)){
            throw IllegalArgumentException("Invalid UUID format for user ID.")
        }
        userDao.insert(user)
        return user
    }

    suspend fun updateUser(user: User) {
        val existingUser = userDao.getUser()
        if (existingUser == null) {
            throw IllegalStateException("No user exists to update. Create a user first.")
        }
        if (user.uid != existingUser.uid) {
            throw IllegalArgumentException("Cannot change the UID of the user.")
        }
        userDao.deleteAll()
        userDao.insert(user)
    }

    suspend fun deleteUser() {
        userDao.deleteAll()
    }
}
