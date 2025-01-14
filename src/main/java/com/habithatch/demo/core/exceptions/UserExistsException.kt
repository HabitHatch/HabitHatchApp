package com.habithatch.demo.core.exceptions

import com.habithatch.demo.data.entities.UserEntity

/**
 * Exception thrown when a user already exists in the database.
 * Only one user is allowed in the local database.
 */
class UserExistsException(
    user: UserEntity,
) : IllegalStateException(
        "Not possible to add UserEntity: ${user.uuid}, because there is already a UserEntity in the Database.",
    )
