package com.habithatch.demo.core.util

import java.time.Instant
import java.time.LocalDate
import java.time.ZoneId
import kotlin.random.Random

fun Instant.minusYears(
    years: Long,
): Instant =
    this
        .atZone(ZoneId.systemDefault())
        .minusYears(years)
        .toInstant()

fun createDate(
    year: Int,
    month: Int,
    day: Int,
): Instant {
    val localDate = LocalDate.of(year, month, day)
    return localDate.atStartOfDay(ZoneId.systemDefault()).toInstant()
}

fun createRandomDate(pastYears: Long): Instant {
    val now = Instant.now()
    val randomSeconds = Random.nextLong(now.minusYears(pastYears).epochSecond, now.epochSecond)
    return Instant.ofEpochSecond(randomSeconds)
}
