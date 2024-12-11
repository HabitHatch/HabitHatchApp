package com.habithatch.demo.core.util

import java.util.UUID

fun isValidUuid(uuid: String): Boolean {
    return try {
        UUID.fromString(uuid)
        true
    } catch (_: IllegalArgumentException) {
        false
    }
}