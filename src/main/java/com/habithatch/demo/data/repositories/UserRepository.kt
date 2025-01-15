package com.habithatch.demo.data.repositories

import com.habithatch.demo.core.exceptions.UserExistsException
import com.habithatch.demo.data.daos.UserDao
import com.habithatch.demo.data.mappers.UserMapper
import com.habithatch.demo.data.models.UserModel
import javax.inject.Inject
import kotlin.jvm.Throws
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

/**
 * [UserRepository] is a repository that provides access to the user in the database.
 * Since there is only one user, the repository provides methods to create, read, update and delete the user.
 */
class UserRepository
    @Inject
    constructor(
        private val userDao: UserDao,
        private val userMapper: UserMapper,
    ) {
        fun getUser(): Flow<UserModel?> = userDao.getUser().map { it?.let(userMapper::asModel) }

        @Throws(UserExistsException::class)
        suspend fun createUser(user: UserModel) {
            val userEntity = userMapper.asEntity(user)
            if (this.hasUser()) throw UserExistsException(userEntity)
            userDao.insert(userEntity)
        }

        /** Deletes all(only one) user from the database. There can only be one user in the database. */
        suspend fun deleteUser() = userDao.deleteAll()

        private suspend fun hasUser() = this.getUser().first() != null
    }
