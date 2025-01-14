package com.habithatch.demo.data.repositories

import com.habithatch.demo.core.exceptions.UserExistsException
import com.habithatch.demo.data.daos.UserDao
import com.habithatch.demo.data.entities.UserEntity
import javax.inject.Inject
import kotlin.jvm.Throws
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first

/**
 * [UserRepository] is a repository that provides access to the user in the database.
 * Since there is only one user, the repository provides methods to create, read, update and delete the user.
 */
class UserRepository
    @Inject
    constructor(
        private val userDao: UserDao,
    ) {
        fun getUser(): Flow<UserEntity?> = userDao.getUser()

        @Throws(UserExistsException::class)
        suspend fun createUser(user: UserEntity) {
            if (this.hasUser()) throw UserExistsException(user)
            userDao.insert(user)
        }

        /**
         * Deletes all(only one) user from the database. There can only be one user in the database.
         * */
        suspend fun deleteUser() = userDao.deleteAll()

        private suspend fun hasUser() = this.getUser().first() != null
    }
