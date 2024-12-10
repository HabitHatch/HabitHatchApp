package com.habithatch.demo.util

import java.util.UUID

fun isValidUuid(uuid: String): Boolean {
    return try {
        UUID.fromString(uuid)
        true
    } catch (e: IllegalArgumentException) {
        false
    }
}