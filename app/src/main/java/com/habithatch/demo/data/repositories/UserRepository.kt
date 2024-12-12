package com.habithatch.demo.data.repositories

import kotlin.jvm.Throws
import com.habithatch.demo.core.util.isValidUuid
import com.habithatch.demo.data.daos.UserDao
import com.habithatch.demo.data.entities.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first

class UserAlreadyExistsException(user: User) : IllegalStateException(
        "Not possible to add User: ${user.uuid}" +
                "There is already a User in the Database." +
                " Delete current User before creating a new one."
)

class InvalidUuidFormatException(uuid: String) : IllegalArgumentException(
        "Invalid UUID format for user ID: $uuid User ID must be a valid UUID."
)

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
