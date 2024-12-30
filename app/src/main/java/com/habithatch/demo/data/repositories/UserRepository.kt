package com.habithatch.demo.data.repositories

import com.habithatch.demo.core.exceptions.UserExistsException
import com.habithatch.demo.data.daos.UserDao
import com.habithatch.demo.data.entities.User
import javax.inject.Inject
import kotlin.jvm.Throws
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first

class UserRepository
    @Inject
    constructor(
        private val userDao: UserDao,
    ) {
        fun getUser(): Flow<User?> = userDao.getUser()

        suspend fun hasUser(): Boolean = this.getUser().first() != null

        @Throws(UserExistsException::class)
        suspend fun createUser(user: User): User {
            if (this.hasUser()) {
                throw UserExistsException(user)
            }
            userDao.insert(user)
            return user
        }

        suspend fun deleteUser() {
            userDao.deleteAll()
        }
    }
