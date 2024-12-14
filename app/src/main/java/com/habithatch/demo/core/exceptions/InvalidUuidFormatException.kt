package com.habithatch.demo.core.exceptions

class InvalidUuidFormatException(uuid: String) : IllegalArgumentException(
        "Invalid UUID format for user ID: $uuid User must be a valid UUID."
)