package com.habithatch.demo.core.util

import java.time.Instant
import java.time.LocalDate
import java.time.ZoneId
import java.time.temporal.ChronoUnit.YEARS
import kotlin.random.Random

fun createDate(
    year: Int,
    month: Int,
    day: Int,
): Instant {
    val localDate = LocalDate.of(year, month, day)
    return localDate.atStartOfDay(ZoneId.systemDefault()).toInstant()
}

fun createRandomDate(): Instant {
    val randomSeconds = Random.nextLong(Instant.now().minus(3, YEARS).epochSecond, Instant.now().epochSecond)
    return Instant.ofEpochSecond(randomSeconds)
}
