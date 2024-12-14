package com.habithatch.demo.data.repositories

import kotlin.jvm.Throws
import com.habithatch.demo.core.exceptions.InvalidUuidFormatException
import com.habithatch.demo.core.exceptions.UserAlreadyExistsException
import com.habithatch.demo.core.util.isValidUuid
import com.habithatch.demo.data.daos.UserDao
import com.habithatch.demo.data.entities.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first

class UserRepository(private val userDao: UserDao) {
    fun getUser(): Flow<User?> {
        return userDao.getUser()
    }

    @Throws(UserAlreadyExistsException::class, InvalidUuidFormatException::class)
    suspend fun createUser(user: User): User {
        val existingUser = this.getUser().first()
        if (existingUser != null) {
            throw UserAlreadyExistsException(user)
        }
        if (!isValidUuid(user.uuid)) {
            throw InvalidUuidFormatException(user.uuid)
        }
        userDao.insert(user)
        return user
    }


    suspend fun deleteUser() {
        userDao.delete()
    }
}
