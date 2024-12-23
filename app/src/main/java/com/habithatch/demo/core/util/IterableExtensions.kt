package com.habithatch.demo.core.util

@Throws(IllegalArgumentException::class)
fun <T, R : Comparable<R>> Collection<T>.getNextHigherOrLowest(
    bySelector: (T) -> R,
    element: T,
): T {
    if (this.isEmpty()) {
        throw IllegalArgumentException("Cannot find next higher element in an empty list")
    }

    val sorted = this.sortedBy(bySelector)
    val elementValue = bySelector(element)

    val nextHigher = sorted.find { bySelector(it) > elementValue }
    return nextHigher ?: sorted.first()
}
