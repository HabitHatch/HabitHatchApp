package com.habithatch.demo.core.exceptions

import com.habithatch.demo.data.entities.User

/**
 * Exception thrown when a user already exists in the database.
 * Only one user is allowed in the local database.
 */
class UserExistsException(
    user: User,
) : IllegalStateException(
        "Not possible to add User: ${user.uuid}, because there is already a User in the Database.",
    )
