package com.habithatch.demo.core.exceptions

/**
 * Exception thrown when a UUID is invalid.
 */
class InvalidUUIdException(
    uuid: String,
    causedBy: Exception,
) : IllegalArgumentException(
        "Invalid UUID format for user ID: $uuid User must be a valid UUID.",
        causedBy,
    )
