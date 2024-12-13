package com.habithatch.demo.data.repositories

import com.habithatch.demo.data.entities.User

class UserAlreadyExistsException(user: User) : IllegalStateException(
        "Not possible to add User: ${user.uuid}, because there is already a User in the Database."
)