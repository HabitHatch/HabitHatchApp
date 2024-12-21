package com.habithatch.demo.core.util

@Throws(IllegalArgumentException::class)
fun <T> Collection<T>.getNextHigherOrLowest(
    comparator: Comparator<T>,
    element: T
): T {
    if(this.isEmpty()) {
        throw IllegalArgumentException("Cannot find next higher element in an empty list")
    }
    val sorted = this.sortedWith(comparator)
    val nextHigher = sorted.find { comparator.compare(it, element) > 0 }
    return nextHigher ?: sorted.first()
}
