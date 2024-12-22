package com.habithatch.demo.data.repositories

import kotlin.jvm.Throws
import com.habithatch.demo.core.exceptions.InvalidUUIdException
import com.habithatch.demo.core.exceptions.UserExistsException
import com.habithatch.demo.core.util.isValidUuid
import com.habithatch.demo.data.daos.UserDao
import com.habithatch.demo.data.entities.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first

class UserRepository(private val userDao: UserDao) {
    fun getUser(): Flow<User?> {
        return userDao.getUser()
    }

    suspend fun hasUser(): Boolean {
        return this.getUser().first() != null
    }

    @Throws(UserExistsException::class, InvalidUUIdException::class)
    suspend fun createUser(user: User): User {
        if (this.hasUser()) {
            throw UserExistsException(user)
        }
        if (!isValidUuid(user.uuid)) {
            throw InvalidUUIdException(user.uuid)
        }
        userDao.insert(user)
        return user
    }


    suspend fun deleteUser() {
        userDao.deleteAll()
    }
}
