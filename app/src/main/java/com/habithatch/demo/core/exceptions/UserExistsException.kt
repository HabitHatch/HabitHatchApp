package com.habithatch.demo.core.exceptions

import com.habithatch.demo.data.entities.User

class UserExistsException(user: User) : IllegalStateException(
        "Not possible to add User: ${user.uuid}, because there is already a User in the Database."
)