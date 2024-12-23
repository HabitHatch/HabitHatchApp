package com.habithatch.demo.core.util

import java.time.LocalDate
import java.time.ZoneId
import java.util.Date

fun createDate(
    year: Int,
    month: Int,
    day: Int,
): Date {
    val localDate = LocalDate.of(year, month, day)
    return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant())
}
