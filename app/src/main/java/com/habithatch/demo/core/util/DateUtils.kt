package com.habithatch.demo.core.util

import java.time.Instant
import java.time.ZoneId
import kotlin.random.Random

/**
 * Returns a new [Instant] that is [years] years after this instant.
 */
fun Instant.minusYears(
    years: Long,
): Instant =
    this
        .atZone(ZoneId.systemDefault())
        .minusYears(years)
        .toInstant()

/**
 * Returns a new random [Instant], that is at most [pastYears] years in the past.
 */
fun createRandomDate(pastYears: Long): Instant {
    val now = Instant.now()
    val randomSeconds = Random.nextLong(now.minusYears(pastYears).epochSecond, now.epochSecond)
    return Instant.ofEpochSecond(randomSeconds)
}
